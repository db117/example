package com.db117.example.test.ext.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author db117
 * @date 2020/9/3/003 15:15
 **/
@Component
@Slf4j
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("bean初始化前,[{}],[{}]", bean.toString(), beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("bean初始化后,[{}],[{}]", bean.toString(), beanName);
        return bean;
    }
}
