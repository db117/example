package com.db117.example.util;

import cn.hutool.core.util.ReflectUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author db117
 * @date 2019/7/15
 **/
@Slf4j
public class BeanUtils {
    /**
     * 设置多种默认值
     *
     * @param map class->默认值
     * @param t   对象
     * @param <T> 范型
     * @return 设置过默认值的对象
     */
    public static <T> T setDefault(Map<Class, Object> map, T t) {
        Field[] fields = ReflectUtil.getFields(t.getClass());
        for (Field field : fields) {
            // 如果有设置默认值
            if (map.containsKey(field.getType())) {
                ReflectUtil.setFieldValue(t, field, map.get(field.getType()));
            }
        }
        return t;
    }

    /**
     * 给对象设置默认BigDecimal
     *
     * @param value 默认值
     * @param t     对象
     * @param <T>   范型
     * @return 设置完成后的对象
     */
    public static <T> T setBigDecimal(BigDecimal value, T t) {
        Field[] fields = ReflectUtil.getFields(t.getClass());
        for (Field field : fields) {
            if (field.getType().equals(BigDecimal.class)) {
                // 设置默认值
                ReflectUtil.setFieldValue(t, field, value);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Test test = new Test();
        BeanUtils.setBigDecimal(BigDecimal.ONE, test);
        System.out.println(test);

        test = new Test();
        Map<Class, Object> map = new HashMap<>();
        map.put(String.class, "123");
        map.put(BigDecimal.class, BigDecimal.TEN);
        BeanUtils.setDefault(map, test);
        System.out.println(test);
    }

    @Data
    static class Test {
        private BigDecimal te;
        private String string;
    }
}
