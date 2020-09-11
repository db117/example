package com.db117.example.test.ext.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author db117
 * @date 2020/9/3/003 14:28
 **/
@Component
@Slf4j
public class ApplicationListenerImpl implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("接受事件 event:[{}]", event.toString());
    }
}
