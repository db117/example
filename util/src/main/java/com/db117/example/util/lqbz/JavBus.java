package com.db117.example.util.lqbz;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author db117
 */
@Slf4j
public class JavBus {
    private static String baseUrl = "https://www.javbus.com/";
    /**
     * 执行线程池
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()
            , Runtime.getRuntime().availableProcessors()
            , 0L
            , TimeUnit.MILLISECONDS
            , new LinkedBlockingQueue<>()
            , new NamedThreadFactory("jav", false));

    /**
     * 进行页面后缀获取所有磁力
     * 获取所有
     *
     * @param suffix  页面后缀(https://www.busdmm.cloud/star/81j > star/81j)
     * @param name    名字
     * @param dirPath 文件夹地址
     */
    public static void process(String suffix, String name, String dirPath) {
        process(suffix, name, dirPath, null);
    }

    /**
     * 进行页面后缀获取所有磁力
     *
     * @param suffix  页面后缀(https://www.busdmm.cloud/star/81j > star/81j)
     * @param name    名字
     * @param dirPath 文件夹地址
     * @param limit   只获取前多少个
     */
    @SneakyThrows
    public static void process(String suffix, String name, String dirPath, Integer limit) {
        // 磁力文件地址
        String magentPath = dirPath + name + "_magent.txt";
        // 未找到番号地址
        String notFindFhPath = dirPath + name + "_not_find_fh.txt";

        AsyncEventBus bus = new AsyncEventBus(executor);
        // 注册消费者
        bus.register(new MagentSearch());


        List<String> hrefs = FhSearch.search(baseUrl + suffix, limit);
        searchMagent(magentPath, bus, hrefs, notFindFhPath);
    }

    /**
     * 从文件获取磁力
     */
    @SneakyThrows
    public static void processByFile(String srcPath, String tarPath) {
        AsyncEventBus bus = new AsyncEventBus(executor);
        // 注册消费者
        bus.register(new MagentSearch());


        List<String> hrefs = FileUtil.readLines(srcPath, StandardCharsets.UTF_8);
        String notFindFhPath = tarPath + ".err";
        searchMagent(srcPath, bus, hrefs, notFindFhPath);
    }

    /**
     * 查询番号
     *
     * @param magentPath    磁力输出地址
     * @param bus           事件
     * @param hrefs         链接集合
     * @param notFindFhPath 异常输出
     */
    private static void searchMagent(String magentPath, AsyncEventBus bus, List<String> hrefs, String notFindFhPath) throws InterruptedException {
        int size = hrefs.size();

        LongAdder remaining = new LongAdder();
        log.info("共{}个", size);
        remaining.add(size);

        hrefs.stream().filter(StrUtil::isNotBlank)
                .forEach(href -> {
                    // 发送事件
                    bus.post(EventObject.builder()
                            .magentPath(magentPath)
                            .notFindFhPath(notFindFhPath)
                            .href(href)
                            .remaining(remaining)
                            .build());
                });

        while (remaining.intValue() > 0) {
            Thread.sleep(1000);
        }
    }

    public static class MagentSearch {
        /**
         * 消费事件
         *
         * @param eventObject 事件对象
         */
        @Subscribe
        @AllowConcurrentEvents
        public void subscribe(EventObject eventObject) {
            try {
                String magent = getMagent(eventObject.getHref());
                // 写入文件
                if (StrUtil.isNotBlank(magent)) {
                    writeToFile(magent, eventObject.getMagentPath());
                } else {
                    writeToFile(eventObject.getHref(), eventObject.getNotFindFhPath());
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                // 出现错误写入文件
                writeToFile(eventObject.getHref(), eventObject.getNotFindFhPath());
            } finally {
                // 打印剩余数量
                eventObject.getRemaining().decrement();
                log.info("剩余{}个", eventObject.getRemaining().intValue());
            }

        }

        /**
         * 查询磁力
         *
         * @param href 番号
         */
        public String getMagent(String href) throws IOException {
            log.info("解析页面{}", href);
            Document document = Jsoup.connect(href)
                    .timeout(60000)
                    .get();
            // 获取ajax参数
            String var = document.select("body > script:nth-child(9)").html();

            // 调用查询番号接口
            String magentUrl = baseUrl + "ajax/uncledatoolsbyajax.php";
            HttpRequest request = HttpUtil.createGet(magentUrl);
            request.header(header(magentUrl)).timeout(60000);
            HttpResponse response = request.form(param(var)).execute();
            // 查找磁力
            return processMagent(response.body());
        }

        /**
         * 解析返回的html
         * 获取文件最大的磁力
         */
        public String processMagent(String html) {
            Document document = Jsoup.parse("<table>" + html + "</table>");
            TreeMap<Double, String> treeMap = new TreeMap<>();


            Elements trs = document.select("tr");
            for (Element element : trs) {
                Elements select = element.select("td:eq(0)");
                if (select.get(0).html().contains("DVD")) {
                    // 去掉 iso
                    continue;
                }
                boolean flag = element.select("td:eq(0) a[title=包含字幕的磁力連結]").size() > 0;

                Element e = element.select("td:eq(1) a").first();
                if (e == null) {
                    continue;
                }
                double size = processSize(e.text());
                if (flag) {
                    size = size * 2;
                }
                treeMap.put(size, e.attr("href"));
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
            } catch (Exception e) {
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
            map.put("lang", "zh");
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
        public static List<String> search(String url, Integer limit) {
            List<String> res = new ArrayList<>();
            int page = 1;
            while (true) {
                log.info("正在解析第{}页", page);
                Connection.Response response = Jsoup.connect(url + "/" + page)
                        .timeout(60000)
                        .ignoreHttpErrors(true)
                        .execute();
                if (response.statusCode() != 200) {
                    break;
                }

                Elements waterfall = response.parse().select("#waterfall");
                if (waterfall == null) {
                    break;
                }
                process(waterfall, res, limit);

                // 限制获取数量(获取前多少条)
                if (limit != null && res.size() >= limit) {
                    break;
                }
                page++;
            }
            return res;
        }

        /**
         * 解析番号
         *
         * @param elements 页面对象
         */
        private static void process(Elements elements, List<String> res, Integer limit) {
            for (int i = 1; i <= 30; i++) {
                String href = elements.select("div:nth-child(" + i + ") > a").attr("href");
                if (StrUtil.isBlank(href)) {
                    continue;
                }
                // 限制获取数量(获取前多少条)
                if (limit != null && res.size() >= limit) {
                    break;
                }
                res.add(href);
            }
        }
    }

    /**
     * 事件对象
     */
    @Getter
    @Builder
    public static class EventObject {
        private String href;
        /**
         * 磁力文件地址
         */
        private String magentPath;
        /**
         * 未找到番号地址
         */
        private String notFindFhPath;
        /**
         * 剩余数量
         */
        private LongAdder remaining;
    }
}
