package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author db117
 * @date 2019/5/19
 **/
@Slf4j
public class Solution7 {
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).replace("-", "").toCharArray();
        // 负数
        boolean minus = x < 0;

        // 翻转数组
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }

        // 去0
        int pre = 0;
        while (pre < chars.length - 1 && chars[pre] == '0') {
            pre++;
        }
        Long aLong = Long.valueOf((minus ? "-" : "") + new String(chars, pre, chars.length - pre));
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return aLong.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
