package com.db117.example.test;

import org.junit.jupiter.api.Test;

/**
 * 正则测试
 *
 * @author db117
 * @date 2021/12/01
 */
public class RegTest {

    @Test
    public void replace() {
        String s = "22.33 44.55";
        String regex = "(\\d+).(\\d+)";
        // 正则替换字符串
        System.out.println(s.replaceAll(regex, "$2 $1"));
        System.out.println(s.replaceFirst(regex, "$2 $1"));
        // 不能使用正则
        System.out.println(s.replace(regex, "$2 $1"));
    }
}
