package com.example.magent;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.StrUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 大兵
 * @date 2018-09-17 23:28
 **/
public class CiliMaoMagent implements PageProcessor, Runnable {
    /**
     * 路径
     */
    private String path;

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public CiliMaoMagent() {
    }

    public CiliMaoMagent(String path) {
        this.path = path;
    }

    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("data", page.getHtml().xpath("//*[@id=\"Information__container___2meHB\"]/div[2]/div[2]/a/@href"));
        page.putField("num", page.getHtml().xpath("//*[@id=\"Information__container___2meHB\"]/div[3]/div[2]/b[2]/text()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"Search__content_left___2MajJ\"]/div[9]/div/a").links().all());
//        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"search-result-ul\"]/li[1]/div[1]/a").links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public  void upload(String code) throws IOException {
        LinkedList<CiliMaoPopeline.Entity> list = new LinkedList<>();
        Spider.create(new CiliMaoMagent())
                .addUrl("http://www.cilimao.cc/search?word=" + code + "&sortProperties=content_size")
                .addPipeline(new CiliMaoPopeline(list))
                .addPipeline(new ConsolePipeline())
                .run();

        String[] split = StrUtil.split(path, "\\");
        String s = split[split.length - 1];
        String replace = StrUtil.replace(s, "_code", "_magent");

        String magentPath = "D:\\webmagic\\" + replace;

        for (CiliMaoPopeline.Entity entity : list) {
            if (entity.getNum() < 3) {
                File file = new File(magentPath);

                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter.create(file).writeLines(CollUtil.newArrayList(entity.getData()), true);
                break;
            }
        }
    }

    @Override
    public void run() {
        List<String> list = FileReader.create(new File(path)).readLines();

        CiliMaoMagent ciliMaoMagent = new CiliMaoMagent();
        for (String s : list) {
            try {
                upload(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        List<String> list = FileReader.create(new File("D:\\webmagic\\Rio（柚木ティナ）_code.txt")).readLines();

        CiliMaoMagent ciliMaoMagent = new CiliMaoMagent();
        for (String s : list) {
//            upload(s);
        }
    }
}
