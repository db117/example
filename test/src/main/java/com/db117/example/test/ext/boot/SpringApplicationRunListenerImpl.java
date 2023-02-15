package com.db117.example.test.ext.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author db117
 * @date 2020/9/3/003 11:19
 **/
@Slf4j
public class SpringApplicationRunListenerImpl implements SpringApplicationRunListener {

    public SpringApplicationRunListenerImpl(SpringApplication application, String... args) {
        log.info("创建 SpringApplicationRunListenerImpl");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        log.info("开始启动 调用SpringApplicationRunListener.starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
                                    ConfigurableEnvironment environment) {
        log.info("环境准备好了 调用SpringApplicationRunListener.environmentPrepared ,environment[{}]", environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("上下文准备好了,但未加载 调用SpringApplicationRunListener.contextPrepared ,context[{}]", context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("上下文加载完成 调用SpringApplicationRunListener.contextLoaded ,context[{}]", context);
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("spring-boot启动完成 调用SpringApplicationRunListener.started ,context[{}]", context);
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("spring-boot启动完成 调用SpringApplicationRunListener.running ,context[{}]", context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("spring-boot启动失败 调用SpringApplicationRunListener.failed ,context[{}]", context);
    }
}
