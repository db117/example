package com.db117.example.test.ext.boot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;


/**
 * @author db117
 * @date 2020/9/3/003 11:00
 **/
@Component
@Slf4j
public class ServletContextInitializerImpl implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("调用ServletContextInitializer.onStartup");
        System.out.println(servletContext);
    }
}
