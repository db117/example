package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author db117
 * @date 2019/5/13
 **/
@Slf4j
public class Solution5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int max = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            int maxLen = 1;
            // aba回文
            while (i - maxLen >= 0 && i + maxLen < length) {
                if (chars[i - maxLen] == chars[i + maxLen]) {
                    // 不相等结束
                    if (maxLen * 2 + 1 >= max) {
                        max = maxLen * 2 + 1;
                        start = i - maxLen;
                    }
                } else {
                    break;
                }
                maxLen++;
            }
            // abba 对称回文
            maxLen = 1;
            while (i + 1 - maxLen >= 0 && i + maxLen < length) {
                if (chars[i + 1 - maxLen] == chars[i + maxLen]) {
                    // 不相等结束
                    if (maxLen * 2 >= max) {
                        max = maxLen * 2;
                        start = i + 1 - maxLen;
                    }
                } else {
                    break;
                }
                maxLen++;
            }
        }
        return new String(chars, start, max);
    }

}
