package com.db117.example.test.ext.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author db117
 * @date 2020/9/3/003 15:14
 **/
@Component
@Slf4j
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("bean定义已经加载完毕,[{ConfigurableListableBeanFactory}]");
    }
}
