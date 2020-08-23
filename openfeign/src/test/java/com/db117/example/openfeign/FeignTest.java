package com.db117.example.openfeign;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@Ignore
public class FeignTest {
    @Autowired
    FeignExample feignExample;

    @Test
    public void db117() {
        System.out.println(feignExample.db117());
    }
}