package com.db117.example.websocket.netty.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author db117
 * @date 2019/5/8
 **/
@SpringBootApplication
public class ServerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
