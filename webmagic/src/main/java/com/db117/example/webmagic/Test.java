package com.db117.example.webmagic;

import cn.hutool.core.thread.NamedThreadFactory;
import com.db117.example.webmagic.magent.CiliMaoMagent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 大兵
 * @date 2018-09-24 18:51
 **/
public class Test {
    public static void main(String[] args) {
        // 文件集合
        File file = new File("D:\\webmagic");
        File[] files = file.listFiles();

        List<String> paths = new ArrayList<>();

        assert files != null;
        for (File file1 : files) {
            if (file1.isFile()) {
                paths.add(file1.getPath());
            }
        }

        // 线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 8,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),new NamedThreadFactory("jav",false));

        paths.forEach(p->{
            threadPool.execute(new CiliMaoMagent(p));
        });

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(2, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
