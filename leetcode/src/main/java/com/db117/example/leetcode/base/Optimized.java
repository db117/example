package com.db117.example.leetcode.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可以再优化
 *
 * @author db117
 * @since 2020/12/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.TYPE})
public @interface Optimized {
}
