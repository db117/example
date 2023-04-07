package com.db117.example.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 数据校验
 *
 * @author 大兵
 * @date 2019/1/2318:27
 */
public class DataCheck {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private DataCheck() {
    }

    /**
     * 校验数据(抛出异常)
     *
     * @param t 数据
     */
    public static <T> void valid(T t) {
        List<String> list = validMessage(t);
        if (CollectionUtil.isNotEmpty(list)) {
            throw new RuntimeException(StrUtil.join(",", list));
        }
    }

    /**
     * 校验数据(抛出异常)
     *
     * @param t      数据
     * @param groups 校验分组
     */
    public static <T> void valid(T t, Class<?>... groups) {
        List<String> list = validMessage(t, groups);
        if (CollectionUtil.isNotEmpty(list)) {
            throw new RuntimeException(StrUtil.join(",", list));
        }
    }

    /**
     * 校验数据
     * 返回所有异常信息
     *
     * @param t 数据
     * @return 所有异常信息
     */
    public static <T> List<String> validMessage(T t) {
        List<String> list = new ArrayList<>();
        validator.validate(t, Default.class).forEach(v -> list.add(v.getMessage()));
        return list;
    }

    /**
     * 校验数据
     * 返回所有异常信息
     *
     * @param t      数据
     * @param groups 校验分组
     * @return 所有异常信息
     */
    public static <T> List<String> validMessage(T t, Class<?>... groups) {
        List<String> list = new ArrayList<>();
        validator.validate(t, groups).forEach(v -> list.add(v.getMessage()));
        return list;
    }

    /**
     * 是否校验通过
     *
     * @param t 数据
     * @return 是否通过
     */
    public static <T> boolean validBool(T t) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(t, Default.class);
        return violationSet.size() == 0;
    }

    /**
     * 是否校验通过
     *
     * @param t      数据
     * @param groups 校验分组
     * @return 是否通过
     */
    public static <T> boolean validBool(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> violationSet = validator.validate(t, groups);
        return violationSet.size() == 0;
    }

    /**
     * 校验数据是否全部b不为空
     *
     * @param data 需要校验的对象
     * @return 是否都不为空
     */
    public static boolean checkNotNull(Object data) {
        AtomicLong total = new AtomicLong();
        Map<String, Object> map = BeanUtil.beanToMap(data);
        map.forEach((s, o) -> {
            if (o == null) {
                total.getAndIncrement();
            }
        });
        return total.get() == 0;
    }

    /**
     * 校验数据是否全部b不为空
     *
     * @param data 需要校验的对象
     * @param num  不为空的属性个数
     * @return 判断不为空的属性是否大于等于total
     */
    public static boolean check(Object data, int num) {
        AtomicLong total = new AtomicLong();
        Map<String, Object> map = BeanUtil.beanToMap(data);
        map.forEach((s, o) -> {
            if (o != null) {
                total.getAndIncrement();
            }
        });

        return total.get() >= num;
    }

    public static void main(String[] args) {
        @Data
        class Testt {
            String s1;
            Integer integer;
        }
        Testt testt = new Testt();
        testt.setS1("1");
        testt.setInteger(1);
        System.out.println(checkNotNull(testt));
        testt.setS1(null);
        System.out.println(checkNotNull(testt));

    }
}
