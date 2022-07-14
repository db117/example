package com.db117.example.util.lqbz;

import cn.hutool.core.io.FileUtil;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://u3c3.com/ 番号查找磁力链接
 *
 * @author db117
 */
@Slf4j
public class BtSearch {

    private BtSearch() {
    }

    /**
     * 解析文件
     *
     * @param sourceFile 编码存放文件
     * @param targetFile 磁力存放文件
     */
    public static void process(String sourceFile, String targetFile) {
        BtSearch search = new BtSearch();
        // 读取所有番号
        Set<String> allNo = search.getAllNo(sourceFile);
        List<String> list = new ArrayList<>();
        for (String s : allNo) {
            System.out.println(s);
            // 找到磁力最大的那个
            search(s).ifPresent(rowObject -> list.add(rowObject.magent));
        }
        // 写入到文件中
        search.writeMagent(list, targetFile);
    }

    /**
     * 根据番号查询磁力
     */
    public static String searchMagentByFh(String fh) {
        return search(fh).map(RowObject::getMagent).orElse(null);
    }

    private Set<String> getAllNo(String filePath) {
        BufferedReader reader = FileUtil.getReader(filePath, StandardCharsets.UTF_8);
        return reader.lines().collect(Collectors.toSet());
    }

    private void writeMagent(List<String> list, String filePath) {
        FileUtil.appendLines(list, filePath, Charset.defaultCharset());
    }

    @SneakyThrows
    private static Optional<RowObject> search(String no) {
        log.info("正在解析{}", no);

        Document document = Jsoup.connect("https://u3c3.com/?search=" + no).get();
        Elements tbody = document.select("body>div.container>div.table-responsive>table>tbody>tr");

        int len = tbody.size();
        List<RowObject> res = new ArrayList<>();
        if (len == 0) {
            return Optional.empty();
        }

        for (int i = 1; i <= len; i++) {
            // 有多行
            res.add(processRow(tbody.select("tr:nth-child(" + i + ")"), no));
        }
        // 找到最大的那个
        return res.stream().max(Comparator.comparingDouble(RowObject::getSize));
    }


    /**
     * 处理行
     *
     * @param tr 表格行对象
     * @param no 编号
     */
    private static RowObject processRow(Elements tr, String no) {
        String size = tr.select("td:nth-child(4)").html();
        return RowObject.builder()
                .no(no)
                .title(tr.select("td:nth-child(2) > a").attr("title"))
                .magent(tr.select("td:nth-child(3) > a:nth-child(2)").attr("href"))
                .size(Double.parseDouble(size.substring(0, size.length() - 2)))
                .build();
    }

    @Builder
    @Data
    private static class RowObject {
        /**
         * 编号
         */
        private String no;
        /**
         * 标题
         */
        private String title;
        /**
         * 磁力链接
         */
        private String magent;
        /**
         * 大小
         */
        private double size;
    }
}
