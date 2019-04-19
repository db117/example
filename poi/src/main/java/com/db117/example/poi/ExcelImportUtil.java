package com.db117.example.poi;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.poi.excel.ExcelFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.Styles;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Excel大数据量导入
 *
 * @author 大兵
 * @date 2019/3/8 11:08
 **/
@Slf4j
public class ExcelImportUtil {
    private OPCPackage xlsxPackage;
    /**
     * 头数组(从左到右)
     */
    private String[] headers;
    /**
     * 处理行数据(k->头)
     */
    private Consumer<Map<String, String>> consumer;
    /**
     * 是否只读第一个sheet页
     */
    private boolean readFirstSheetOnly;


    public ExcelImportUtil(OPCPackage xlsxPackage, String[] headers, Consumer<Map<String, String>> consumer) {
        this.xlsxPackage = xlsxPackage;
        this.headers = headers;
        this.consumer = consumer;
    }

    /**
     * 导入Excel
     *
     * @param tClass 转换后对象
     * @param file   导入的文件
     * @param header Excel头转对象
     * @return 对象集合
     */
    public static <T> List<T> doImport(Class<T> tClass
            , File file
            , String[] header) {
        check(file);

        List<T> list = new ArrayList<>();
        try (OPCPackage p = OPCPackage.open(file, PackageAccess.READ)) {
            ExcelImportUtil excelImportUtil = new ExcelImportUtil(
                    p
                    , header
                    // 转换为对象,并添加到集合中
                    , map -> list.add(BeanUtil.mapToBean(map, tClass, true)));
            excelImportUtil.process();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * 导入Excel
     *
     * @param file   导入的文件
     * @param header Excel头转对象
     * @return 对象集合
     */
    public static List<Map<String, String>> doImport(File file
            , String[] header) {
        check(file);

        List<Map<String, String>> list = new ArrayList<>();
        try (OPCPackage p = OPCPackage.open(file, PackageAccess.READ)) {
            ExcelImportUtil excelImportUtil = new ExcelImportUtil(
                    p
                    , header
                    , list::add);
            // 执行解析
            excelImportUtil.process();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * 解析Excel
     *
     * @throws IOException  如果从包中读取数据失败
     * @throws SAXException 如果解析XML数据失败
     */
    public void process() throws IOException, OpenXML4JException, SAXException {
        // 只读字符表
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
        // Xssf读取
        XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
        // 样式表
        StylesTable styles = xssfReader.getStylesTable();
        // 读取Excel
        XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
        while (iter.hasNext()) {
            try (InputStream stream = iter.next()) {
                processSheet(styles
                        , strings
                        , new SimpleSheetContentsHandler(headers, consumer)
                        , stream);
            }
            // 当自读第一个sheet是结束
            if (readFirstSheetOnly) {
                break;
            }
        }
    }

    /**
     * 解析一个表的内容使用指定的样式和共享字符串表
     *
     * @param styles           可以通过表中的单元格引用的样式表
     * @param strings          可以通过表中的单元格引用的字符串表
     * @param sheetInputStream 这条流读取了文件数据
     * @throws IOException  来自解析器的IO异常,可能来自字节流或字符流
     * @throws SAXException 如果解析XML数据失败
     */
    private void processSheet(
            Styles styles,
            SharedStrings strings,
            SheetContentsHandler sheetHandler,
            InputStream sheetInputStream) throws IOException, SAXException {
        // 数据格式化对象
        DataFormatter formatter = new DataFormatter();
        formatter.addFormat("m/d/yy", new SimpleDateFormat("yyyy/MM/dd"));
        InputSource sheetSource = new InputSource(sheetInputStream);
        try {
            // xml读取类
            XMLReader sheetParser = SAXHelper.newXMLReader();
            // xml处理方法
            ContentHandler handler = new XSSFSheetXMLHandler(
                    styles
                    , null
                    , strings
                    , sheetHandler
                    , formatter
                    , false);
            sheetParser.setContentHandler(handler);

            // 解析Excel
            sheetParser.parse(sheetSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    private class SimpleSheetContentsHandler implements SheetContentsHandler {
        /**
         * 当前行号
         */
        private int currentRow = -1;
        /**
         * 当前列号
         */
        private int currentCol = -1;
        /**
         * 当前行数据
         */
        private Map<String, String> rowData;
        /**
         * 数据头
         */
        private String[] headers;
        /**
         * 数据处理方法
         */
        private Consumer<Map<String, String>> consumer;
        /**
         * 是否读取第一行
         */
        private boolean readFirst;
        /**
         * 是否读取空行
         */
        private boolean readNullRaw;

        /**
         * sheet页处理
         *
         * @param headers  表头数组
         * @param consumer 行消费
         */
        SimpleSheetContentsHandler(String[] headers
                , Consumer<Map<String, String>> consumer) {
            this.headers = headers;
            this.consumer = consumer;
        }

        /**
         * sheet页处理
         *
         * @param headers     表头数组
         * @param consumer    行消费
         * @param readFirst   是否读取第一行
         * @param readNullRaw 是否读取空行
         */
        public SimpleSheetContentsHandler(String[] headers
                , Consumer<Map<String, String>> consumer
                , boolean readFirst
                , boolean readNullRaw) {
            this.headers = headers;
            this.consumer = consumer;
            this.readFirst = readFirst;
            this.readNullRaw = readNullRaw;
        }

        @Override
        public void startRow(int rowNum) {
            currentRow = rowNum;
            currentCol = -1;
            // 重置数据
            rowData = new HashMap<>(headers.length);
        }

        @Override
        public void endRow(int rowNum) {
            // 不处理第一行
            if (!readFirst && rowNum == 0) {
                return;
            }
            // 空行处理
            if (!readNullRaw && rowData.isEmpty()) {
                return;
            }
            // 处理数据
            consumer.accept(rowData);
        }

        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            // 如果为空则生成一个当前位置的单元格对象
            if (cellReference == null) {
                cellReference = new CellAddress(currentRow, currentCol).formatAsString();
            }

            // 读取的列号
            int thisCol = (new CellReference(cellReference)).getCol();
            // 大于头的列不处理
            if (thisCol >= this.headers.length) {
                return;
            }
            // 列为空的数量
            int missedCols = thisCol - currentCol - 1;
            for (int i = 0; i < missedCols; i++) {
                rowData.put(headers[currentCol + i + 1], null);
            }
            // 当前行等于读取的列
            currentCol = thisCol;
            // 大于头的列不处理
            if (currentCol > headers.length) {
                return;
            }
            // 设置值
            rowData.put(headers[currentCol], formattedValue);
        }
    }

    public static void check(File file) {
        // 判断是否是07版Excel
        try (InputStream is = new FileInputStream(file)) {
            boolean xlsx = ExcelFileUtil.isXlsx(is);
            if (!xlsx) {
                // 文件不是07版Excel
                throw new RuntimeException("file is not OOXML(07Excel,xlsx)");
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}