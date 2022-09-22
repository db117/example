/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.db117.example.spring.cloud.gateway;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.SocketUtils;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

/**
 * gateway网关测试
 */
@SpringBootTest(classes = {GatewaySampleApplicationTests.TestConfig.class}, webEnvironment = DEFINED_PORT)
public class GatewaySampleApplicationTests {


    @LocalServerPort
    protected int port = 0;

    protected WebTestClient webClient;

    protected String baseUri;

    protected static int targetPort;

    static DisposableServer httpServer;

    @BeforeAll
    public static void beforeClass() {

        targetPort = SocketUtils.findAvailableTcpPort();
        httpServer = HttpServer.create()
                .port(targetPort)
                .route(r -> r.route(rs -> true, (res, rep) -> rep.sendString(Mono.just("123"))))
                .bindNow();
    }

    @AfterAll
    public static void afterAll() {
        httpServer.disposeNow();
    }

    @BeforeEach
    public void setup() {
        baseUri = "http://localhost:" + port;
        this.webClient = WebTestClient.bindToServer().responseTimeout(Duration.ofSeconds(10)).baseUrl(baseUri).build();
    }

    @Test
    public void contextLoads() {
        webClient.get().uri("/get").exchange().expectStatus().isOk();
    }

    @SpringBootConfiguration
    @EnableAutoConfiguration
    public static class TestConfig {

        @Bean
        public RouteLocator routes(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route(p -> p.path("/**").uri("HTTP://127.0.0.1:" + targetPort)).build();
        }

    }

}
