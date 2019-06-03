package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author db117
 * @date 2019/6/3
 **/
@Slf4j
public class Solution14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            // 一个都没有
            return "";
        }
        if (strs.length == 1) {
            // 只有一个
            return strs[0];
        }

        // 找到最短的字符串
        int minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        if (minLen == 0) {
            // 有为空字符串的,返回空字符串
            return "";
        }

        // 是否找的
        boolean flag = true;
        // 最大长度
        int index = 0;
        // 循环最短字符串
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            // 从第二个字符串开始循环字符串数组
            for (int z = 1; z < strs.length; z++) {
                if (strs[z].charAt(i) != c) {
                    // 如果跟第一个不一样中断
                    flag = false;
                    break;
                }
            }

            // 记录下表
            if (flag) {
                index = i + 1;
            }
        }
        return strs[0].substring(0, index);
    }
}
