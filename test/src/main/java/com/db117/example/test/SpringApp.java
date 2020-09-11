package com.db117.example.test;

import com.db117.example.test.ext.boot.BannerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author db117
 * @date 2020/8/26/026 15:31
 **/
@SpringBootApplication
public class SpringApp {

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(SpringApp.class);
        application.setBanner(new BannerImpl());

        application.run();
    }
}
