package com.db117.example.openfeign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author db117
 * @date 2019/7/18
 **/
@Slf4j
@SpringBootApplication
@EnableFeignClients
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
