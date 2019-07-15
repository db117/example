package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/13
 **/
@Slf4j
public class Solution28 {
    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("mississippi",
                "pi"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] data = haystack.toCharArray();
        char[] find = needle.toCharArray();

        if (data.length == find.length) {
            // 长度相等直接比较
            return Arrays.equals(data, find) ? 0 : -1;
        }
        for (int i = 0; i < data.length - find.length + 1; i++) {
            // 找到第一个匹配的
            for (int j = 0; j < find.length; j++) {
                if (data[i + j] != find[j]) {
                    // 有不匹配的直接跳过
                    break;
                }
                if (j == find.length - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
