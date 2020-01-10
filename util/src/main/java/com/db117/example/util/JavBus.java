package com.db117.example.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * @author db117
 */
@Slf4j
public class JavBus {
    private static String baseUrl = "https://www.busdmm.cloud/";

    /**
     * 进行页面后缀获取所有磁力
     *
     * @param suffix  页面后缀(https://www.busdmm.cloud/star/81j > 81j)
     * @param name    名字
     * @param dirPath 文件夹地址
     */
    public static void process(String suffix, String name, String dirPath) {
        List<String> fhs = FhSearch.search(baseUrl + "star/" + suffix);

        // 磁力文件地址
        String magentPath = dirPath + name + "_magent.txt";
        // 未找到番号地址
        String notFindFhPath = dirPath + name + "_not_find_fh.txt";

        for (int i = 0, fhsSize = fhs.size(); i < fhsSize; i++) {
            String fh = fhs.get(i);
            log.info("进行第{}个番号,总{}个", i, fhsSize);
            try {
                String magent = MagentSearch.getMagent(fh);
                if (StrUtil.isNotBlank(fh)) {
                    FileUtil.appendUtf8Lines(Collections.singletonList(magent), magentPath);
                } else {
                    FileUtil.appendUtf8Lines(Collections.singletonList(fh), notFindFhPath);
                }
            } catch (Throwable e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public static class MagentSearch {
        /**
         * 根据番号获取磁力
         * 最大的那个
         */
        @SneakyThrows
        public static String getMagent(String fh) {
            log.info("解析番号{}", fh);
            String pageUrl = baseUrl + fh;
            Document document = Jsoup.connect(pageUrl).get();
            // 获取ajax参数
            String var = document.select("body > script:nth-child(9)").html();

            String magentUrl = baseUrl + "ajax/uncledatoolsbyajax.php";
            HttpRequest request = HttpUtil.createGet(magentUrl);
            request.header(header(magentUrl));
            HttpResponse response = request.form(param(var)).execute();
            return processMagent(response.body());
        }

        /**
         * 解析返回的html
         */
        public static String processMagent(String html) {
            Document document = Jsoup.parse(html);
            TreeMap<Double, String> treeMap = new TreeMap<>();
            Elements elements = document.select("a[rel=nofollow]");

            for (int i = 0; i < elements.size(); i += 3) {
                Element element = elements.get(i + 1);
                String size = element.text();
                treeMap.put(processSize(size), element.attr("href"));
            }

            // 找到最大的
            return treeMap.lastEntry().getValue();
        }

        private static double processSize(String size) {
            double d = 0;
            try {
                d = Double.parseDouble(size.substring(0, size.length() - 2));
            } catch (NumberFormatException e) {
                return 0;
            }
            String last = size.substring(size.length() - 2, size.length());
            if ("GB".equals(last)) {
                return d * 1000;
            }
            return d;
        }

        /**
         * 请求头
         */
        private static Map<String, List<String>> header(String url) {
            Map<String, List<String>> map = new HashMap<>();
            map.put("User-Agent", Collections.singletonList("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36"));
            map.put("Connection", Collections.singletonList("close"));
            map.put("X-Requested-With", Collections.singletonList("XMLHttpRequest"));
            map.put("Referer", Collections.singletonList(url));
            return map;
        }

        /**
         * 解析参数
         */
        private static Map<String, Object> param(String s) {
            Map<String, Object> map = new HashMap<>();
            //	var gid = 42208030086;
            //	var uc = 0;
            //	var img = 'https://pics.javcdn.pw/cover/7h4c_b.jpg';
            String replace = s.replace("var gid = ", "")
                    .replace("var uc = ", "")
                    .replace("var img = ", "")
                    .replaceAll("'", "")
                    .replaceAll("\\t", "")
                    .replaceAll("\\n", "");

            String[] split = replace.split(";");
            map.put("gid", split[0].trim());
            map.put("uc", split[1].trim());
            map.put("img", split[2].trim());
            return map;
        }
    }


    /**
     * 番号搜索
     *
     * @author db117
     */
    @Slf4j
    public static class FhSearch {

        private FhSearch() {
        }

        /**
         * 根据页面查询所有番号
         *
         * @param url url(不带翻页号)
         */
        @SneakyThrows
        public static List<String> search(String url) {
            List<String> res = new ArrayList<>();
            int page = 1;
            while (true) {
                log.info("正在解析第{}页", page);
                Connection.Response response = Jsoup.connect(url + "/" + page).ignoreHttpErrors(true).execute();
                if (response.statusCode() != 200) {
                    break;
                }

                Elements waterfall = response.parse().select("#waterfall");
                if (waterfall == null) {
                    break;
                }
                res.addAll(process(waterfall));

                page++;
            }
            return res;
        }

        /**
         * 解析番号
         *
         * @param elements 页面对象
         */
        private static List<String> process(Elements elements) {
            List<String> res = new ArrayList<>(30);
            for (int i = 1; i <= 30; i++) {
                String fh = elements.select("div:nth-child(" + i + ") > a > div.photo-info > span > date:nth-child(3)").html();
                if (StrUtil.isBlank(fh)) {
                    continue;
                }
                res.add(fh);
            }
            return res;
        }
    }
}
