package com.example.code;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author 大兵
 * @date 2018-09-16 0:45
 **/
public class JavTest implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("data", page.getHtml().xpath("/html/body/div[5]/div[1]/div[2]/p[1]/span[2]/text()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"waterfall\"]/div/a").links().all());
        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"next\"]").links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JavTest())
                .addUrl("https://www.seedmm.co/star/pdb")
                .addPipeline(new FileUpdate("向井藍"))
                .addPipeline(new ConsolePipeline())
                .run();

    }
}
