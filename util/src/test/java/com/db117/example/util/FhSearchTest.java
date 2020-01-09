package com.db117.example.util;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FhSearchTest {


    @Test
    public void search() {
        List<String> fhs = JavBus.FhSearch.search("https://www.busdmm.cloud/star/81j");
        List<String> magents = new ArrayList<>();

        int total = fhs.size();
        for (String fh : fhs) {
            String magent = JavBus.MagentSearch.getMagent(fh);
            FileUtil.appendUtf8Lines(Collections.singletonList(magent), "D:\\webmagic\\蓮実クレア_magent.txt");
            magents.add(magent);
        }
        System.out.println(magents.size());
    }
}