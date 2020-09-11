package com.db117.example.test.ext.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author db117
 * @date 2020/9/3/003 11:05
 **/
@Component
@Slf4j
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("在springboot启动完成后调用CommandLineRunner.run args[{}]", Arrays.toString(args));
    }
}
