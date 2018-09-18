import cn.hutool.core.io.file.FileReader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.util.List;

/**
 * @author 大兵
 * @date 2018-09-17 0:30
 **/
public class MagentTest implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("data", page.getHtml().xpath("//*[@id=\"search-result-ul\"]/li[1]/div[2]/div/a/text()"));

        // 部分三：从页面发现后续的url地址来抓取
//        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"waterfall\"]/div/a").links().all());
//        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"search-result-ul\"]/li[1]/div[1]/a").links().all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void update(String name) {
        Spider.create(new MagentTest())
                .addUrl("http://btstation.com/search/all/"+name)
                .addPipeline(new MagentUpdate())
                .addPipeline(new ConsolePipeline())
                .run();
    }
    public static void main(String[] args) {
        List<String> list = FileReader.create(new File("D:\\webmagic\\ティア.txt")).readLines();

        MagentTest magentTest = new MagentTest();
        list.forEach(magentTest::update);

    }

}
