package com.db117.example.test.ext.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author db117
 * @date 2020/9/3/003 11:28
 **/
@Slf4j
public class BannerImpl implements Banner {
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        log.info("打印横幅 Banner.printBanner");
        out.println("就是这么帅!!!");
    }
}
