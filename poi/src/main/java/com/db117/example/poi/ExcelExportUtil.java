package com.db117.example.poi;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * excel根据模板导出
 * 模板需要标题行,以及第一行数据行(提供样式)
 *
 * @author db117
 * @date 2019/12/23/023 11:02
 */
@Slf4j
public class ExcelExportUtil {
    private static ThreadLocal<ExportObject> threadLocal = new ThreadLocal<>();

    /**
     * 构建导出对象(默认关闭输入流)
     *
     * @param inputStream 模板文件流
     * @param objectKey   对象key对应得列数(0开始)
     * @param sheetMaxRow 单sheet大小(2-100W)
     */
    public static void build(InputStream inputStream, String[] objectKey, int sheetMaxRow) {
        build(inputStream, true, objectKey, sheetMaxRow);
    }

    /**
     * 构建导出对象
     *
     * @param inputStream   模板文件流
     * @param isCloseStream 是否关闭流
     * @param objectKey     对象key对应得列数(0开始)
     * @param sheetMaxRow   单sheet大小(2-100W)
     */
    @SneakyThrows({IOException.class})
    public static void build(InputStream inputStream, boolean isCloseStream, String[] objectKey, int sheetMaxRow) {
        if (sheetMaxRow > 1000000 || sheetMaxRow < 2) {
            throw new IllegalArgumentException("单sheet最大行不正确");
        }
        threadLocal.remove();

        CellStyle[] contentCellStyles;
        String[] headTitle;
        CellStyle[] headCellStyles;

        // 为不影响源文件,不直接读取文件
        InputStream is = new ByteArrayInputStream(IoUtil.readBytes(inputStream, isCloseStream));
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 样式行
        XSSFRow row = sheet.getRow(1);
        // 列数(0开始)
        int len = row.getLastCellNum();

        // 数据样式
        contentCellStyles = new CellStyle[len];
        row.iterator().forEachRemaining(cell -> contentCellStyles[cell.getColumnIndex()] = cell.getCellStyle());

        // 表头
        XSSFRow rowHead = sheet.getRow(0);
        headTitle = new String[len];
        headCellStyles = new CellStyle[len];
        rowHead.iterator().forEachRemaining(cell -> {
            headCellStyles[cell.getColumnIndex()] = cell.getCellStyle();
            headTitle[cell.getColumnIndex()] = cell.getStringCellValue();
        });

        // 列宽
        int[] colWidth = new int[len];
        for (int i = 0; i < colWidth.length; i++) {
            colWidth[i] = sheet.getColumnWidth(i);
        }

        // 删除所有内容
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            workbook.removeSheetAt(i);
        }

        ExportObject exportObject = new ExportObject()
                .setHeadCellStyles(headCellStyles)
                .setHeadTitle(headTitle)
                .setWorkbook(new SXSSFWorkbook(workbook))
                .setContentCellStyles(contentCellStyles)
                .setObjectKey(objectKey)
                .setSheetMaxRow(sheetMaxRow)
                .setColWidth(colWidth);
        threadLocal.set(exportObject);
    }

    /**
     * 写入数据
     */
    public static void writeMap(List<Map<String, Object>> data) {
        for (Map<String, Object> map : data) {
            writeByRow(map);
        }
    }

    /**
     * 写入数据
     */
    public static void writeObject(List data) {
        for (Object o : data) {
            writeByRow(BeanUtil.beanToMap(o));
        }
    }

    /**
     * 导出空数据文件,包含表头
     */
    public static File stopNotDate() {
        getSheet();
        return stop();
    }

    /**
     * 导出结束
     */
    @SneakyThrows
    public static File stop() {
        ExportObject exportObject = threadLocal.get();
        File tempFile = File.createTempFile("excelExport", ".xlsx");
        try (SXSSFWorkbook workbook = exportObject.workbook;
             OutputStream outputStream = new FileOutputStream(tempFile)) {
            workbook.write(outputStream);
        }
        return tempFile;
    }

    /**
     * 写入行
     */
    private static void writeByRow(Map<String, Object> map) {
        checkRange();
        ExportObject exportObject = threadLocal.get();

        SXSSFSheet sheet = getSheet();

        // 获取行对象
        SXSSFRow row = sheet.createRow(exportObject.rowNum);

        // 内容
        String[] objectKey = exportObject.getObjectKey();
        for (int i = 0; i < objectKey.length; i++) {
            SXSSFCell cell = row.createCell(i);
            cell.setCellStyle(exportObject.contentCellStyles[i]);
            // 处理数据
            Object o = map.get(objectKey[i]);

            if (o == null) {
                continue;
            }

            setValue(o, cell);
        }

        exportObject.rowNum++;
    }

    /**
     * 设置单元格值
     *
     * @param o    值对象
     * @param cell Excel单元格对象
     */
    private static void setValue(Object o, SXSSFCell cell) {
        // 根据类型处理数据
        switch (o.getClass().getName()) {
            case "java.lang.Number":
                cell.setCellValue(((Number) o).doubleValue());
                break;
            case "java.util.Date":
                cell.setCellValue((Date) o);
                break;
            case "java.time.LocalDateTime":
                cell.setCellValue((LocalDateTime) o);
                break;
            case "java.time.LocalDate":
                cell.setCellValue((LocalDate) o);
                break;
            case "java.lang.Boolean":
                cell.setCellValue((Boolean) o);
                break;
            case "java.util.Calendar":
                cell.setCellValue((Calendar) o);
                break;
            default:
                cell.setCellValue(new XSSFRichTextString(o.toString()));
        }
    }

    /**
     * 获取当前写入行的sheet
     */
    private static SXSSFSheet getSheet() {
        checkRange();
        ExportObject exportObject = threadLocal.get();
        SXSSFWorkbook workbook = exportObject.workbook;

        if (exportObject.rowNum != 0) {
            return workbook.getSheetAt(exportObject.currentSheetIndex);
        }
        SXSSFSheet sheet = null;
        if (exportObject.currentSheetIndex != 0) {
            // 需要创建sheet
            sheet = workbook.createSheet();
        }
        if (exportObject.currentSheetIndex == 0) {
            // 第一个sheet直接获取
            if (workbook.getNumberOfSheets() == 0) {
                sheet = workbook.createSheet();
            } else {
                sheet = workbook.getSheetAt(0);
            }
        }

        // 设置列宽
        for (int i = 0; i < exportObject.colWidth.length; i++) {
            sheet.setColumnWidth(i, exportObject.colWidth[i]);
        }

        // 第一行写入头
        writeTitle();
        return sheet;
    }

    private static void checkRange() {
        ExportObject exportObject = threadLocal.get();
        if (exportObject.rowNum > exportObject.getSheetMaxRow()) {
            exportObject.rowNum = 0;
            exportObject.currentSheetIndex++;
        }
    }

    /**
     * 新sheet写入头
     */
    private static void writeTitle() {
        ExportObject exportObject = threadLocal.get();
        // 获取行对象
        SXSSFRow row = exportObject.getWorkbook()
                .getSheetAt(exportObject.currentSheetIndex)
                .createRow(exportObject.rowNum);
        // 表头
        String[] title = exportObject.getHeadTitle();

        for (int i = 0, titleLength = title.length; i < titleLength; i++) {
            SXSSFCell cell = row.createCell(i);
            cell.setCellStyle(exportObject.headCellStyles[i]);
            cell.setCellValue(title[i]);
        }
        exportObject.rowNum++;
    }

    /**
     * 导出中转对象
     */
    @Data
    @Accessors(chain = true)
    private static class ExportObject {
        /**
         * 导出Excel对象
         */
        private SXSSFWorkbook workbook;
        /**
         * 内容样式
         */
        private CellStyle[] contentCellStyles;
        /**
         * 行号
         */
        private int rowNum;
        /**
         * 样式头部
         */
        private CellStyle[] headCellStyles;
        /**
         * 头部标题
         */
        private String[] headTitle;
        /**
         * 导出对象的key
         */
        private String[] objectKey;
        /**
         * 列宽
         */
        private int[] colWidth;
        /**
         * 当前sheet
         */
        private int currentSheetIndex;
        /**
         * 单sheet最大行,默认100万
         */
        private int sheetMaxRow = 1000000;
    }
}