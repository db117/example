package com.db117.example.webmagic.magent;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author 大兵
 * @date 2018-09-17 23:18
 **/
@TargetUrl("http://www.cilimao.cc/information/\\w+/\\w+")
@HelpUrl("http://www.cilimao.cc/search/\\w+")
public class Magent {
    @ExtractBy(value = "//*[@id=\"Information__container___2meHB\"]/div[2]/div[2]/a/@href", notNull = true)
    private String data;

//    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
//    private String author;

    @ExtractBy("//*[@id=\"Information__container___2meHB\"]/div[3]/div[2]/b[2]/text()")
    private String readme;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), Magent.class)
                .addUrl("http://www.cilimao.cc/search?word=REBDB-017&sortProperties=content_size").thread(5).run();
    }
}
