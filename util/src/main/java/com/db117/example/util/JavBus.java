package com.db117.example.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.NamedThreadFactory;
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

import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    @SneakyThrows
    public void process(String suffix, String name, String dirPath) {
        List<String> fhs = FhSearch.search(baseUrl + "star/" + suffix);
        // 存放番号的队列
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        for (String fh : fhs) {
            queue.offer(fh);
        }
        log.info("共{}个", fhs.size());
        // 执行线程池
        int threadSize = 8;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(threadSize
                , threadSize
                , 0L
                , TimeUnit.MILLISECONDS
                , new LinkedBlockingQueue<Runnable>()
                , new NamedThreadFactory("jav", false));
        ;
        // 磁力文件地址
        String magentPath = dirPath + name + "_magent.txt";
        // 未找到番号地址
        String notFindFhPath = dirPath + name + "_not_find_fh.txt";


        for (int i = 0; i < threadSize; i++) {
            executor.execute(new MagentSearch(magentPath, notFindFhPath, queue));
        }

        while (executor.getActiveCount() != 0) {
            Thread.sleep(5000);
        }
    }

    public static class MagentSearch implements Runnable {
        /**
         * 磁力文件地址
         */
        String magentPath;
        /**
         * 未找到番号地址
         */
        String notFindFhPath;
        LinkedBlockingQueue<String> queue;

        public MagentSearch(String magentPath, String notFindFhPath, LinkedBlockingQueue<String> queue) {
            this.magentPath = magentPath;
            this.notFindFhPath = notFindFhPath;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                String fh = queue.poll();
                try {
                    log.info("剩余{}个", queue.size());
                    getMagent(fh);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                    writeToFile(fh, notFindFhPath);
                }
            }
        }

        /**
         * 查询磁力
         *
         * @param fh 番号
         */
        private void getMagent(String fh) throws IOException {
            log.info("解析番号{}", fh);
            String pageUrl = baseUrl + fh;
            Document document = Jsoup.connect(pageUrl).get();
            // 获取ajax参数
            String var = document.select("body > script:nth-child(9)").html();

            // 调用查询番号接口
            String magentUrl = baseUrl + "ajax/uncledatoolsbyajax.php";
            HttpRequest request = HttpUtil.createGet(magentUrl);
            request.header(header(magentUrl)).timeout(5000);
            HttpResponse response = request.form(param(var)).execute();
            // 查找磁力
            String magent = processMagent(response.body());
            if (StrUtil.isNotBlank(magent)) {
                // 写入文件
                writeToFile(magent, magentPath);
            }
        }

        /**
         * 解析返回的html
         * 获取文件最大的磁力
         */
        private String processMagent(String html) {
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

        /**
         * 解析出文件大小
         *
         * @param size 文本
         * @return 大小mb
         */
        private double processSize(String size) {
            double d;
            try {
                d = Double.parseDouble(size.substring(0, size.length() - 2));
            } catch (NumberFormatException e) {
                return 0;
            }
            String last = size.substring(size.length() - 2);
            if ("GB".equals(last)) {
                return d * 1000;
            }
            return d;
        }

        /**
         * 请求头
         */
        private Map<String, List<String>> header(String url) {
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
        private Map<String, Object> param(String s) {
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

        @SneakyThrows
        private void writeToFile(String text, String path) {
            FileUtil.appendUtf8Lines(Collections.singletonList(text), path);
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
