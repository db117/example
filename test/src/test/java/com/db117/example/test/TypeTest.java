package com.db117.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author db117
 * @since 2023/2/8
 */
public class TypeTest {

    @Test
    public void returnType() {
        // 通过返回值来获取泛型类型
        Class<Integer> c = TypeMethod.a();
        Assertions.assertEquals(Integer.class, c);
    }

    public static class TypeMethod {
        @SuppressWarnings("unchecked")
        public static <T> Class<T> a(T... reified) {
            return (Class<T>) reified.getClass().getComponentType();
        }
    }
}
