package com.db117.example.util;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class JavBusTest {
    @Before
    public void setUp() throws Exception {
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "" + "7777");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "7777");
    }

    @Test
    public void process() {

        JavBus.process("star/2jv", "波多野結衣", "D:\\jav\\", 3);
    }

    @Test
    public void t() throws IOException {


        JavBus.MagentSearch search = new JavBus.MagentSearch();

        String s = search.getMagent("https://www.javbus.com/NGOD-123");
        System.out.println(s);
    }
}