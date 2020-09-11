package com.db117.example.test.ext.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author db117
 * @date 2020/9/3/003 11:03
 **/
@Slf4j
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("在springboot启动完成后调用ApplicationRunner.run,args[{}]", args);
    }
}
