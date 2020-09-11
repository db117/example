package com.db117.example.test.ext.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author db117
 * @date 2020/9/3/003 14:47
 **/
@Component
@Slf4j
public class ExampleBean implements ApplicationContextAware,
        ApplicationEventPublisherAware,
        BeanFactoryAware,
        BeanNameAware,
        EmbeddedValueResolverAware,
        EnvironmentAware,
        DisposableBean,
        InitializingBean,
        SmartInitializingSingleton,
        ServletContextAware {
    /**
     * 事件发布
     */
    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;
    @Autowired
    private HttpServletRequest request;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("注入applicationContext,[{}]", applicationContext.getClass().getName());
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("注入ApplicationEventPublisher,[{}]", applicationEventPublisher.getClass().getName());
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("注入BeanFactory,BeanFactory:[{}]", beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(String name) {
        log.info("设置BeanName,name[{}]", name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("注入StringValueResolver 调用EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("注入 environment");
    }

    @Override
    public void destroy() throws Exception {
        log.info("bean销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("bean初始化完成,设置参数");
    }

    @Override
    public void afterSingletonsInstantiated() {
        // 当所有单例 bean 都初始化完成以后， 容器会回调该接口的方法 `afterSingletonsInstantiated`。
        // 保证在所有非懒加载的单例bean都加载完成后调用
        log.info("所有单例 bean 都初始化完成以");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        log.info("注入ServletContext,[{}]", servletContext.getClass().getName());
    }
}
