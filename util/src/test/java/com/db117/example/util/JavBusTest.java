package com.db117.example.util;

import com.db117.example.util.lqbz.JavBus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

@Ignore
public class JavBusTest {
    @Before
    public void setUp() throws Exception {
//        System.setProperty("http.proxySet", "true");
//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "" + "10808");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyPort", "10808");
        System.getProperties().put("socksProxySet", "true");
        System.getProperties().put("socksProxyHost", "localhost");
        System.getProperties().put("socksProxyPort", "10808");
    }

    @Test
    public void process() {

        JavBus.process("uncensored/star/kxe", "麻生希", "D:\\jav\\");
    }

    @Test
    public void precessByFile() {
        JavBus.processByFile("D:\\jav\\龍縛_not_find_fh.txt", "D:\\jav\\龍縛_magent.txt");
    }

    @Test
    public void t() throws IOException {


        JavBus.MagentSearch search = new JavBus.MagentSearch();

        String s = search.getMagent("https://www.javbus.com/NGOD-123");
        System.out.println(s);
    }
}