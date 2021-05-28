package com.db117.example.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author db117
 * @date 2021/5/28
 */
public class IntegerTest {

    @Test
    public void cache() throws NoSuchFieldException, IllegalAccessException {
        // integer 缓存

        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        // array[129] is 1
        array[130] = array[129];
        // Set 2 to be 1
        array[131] = array[129];
        // Set 3 to be 1
        Integer a = 1;
        if (a == (Integer) 1 && a == (Integer) 2 && a == (Integer) 3) {
            System.out.println("Success");
        }
    }
}
