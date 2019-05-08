package com.db117.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author db117
 * @date 2019/5/8
 **/
@SpringBootApplication
@EnableWebSocket
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
