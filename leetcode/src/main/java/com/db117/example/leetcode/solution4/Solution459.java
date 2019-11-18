package com.db117.example.leetcode.solution4;

import java.util.ArrayList;
import java.util.List;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/17/017 17:25
 */
public class Solution459 {
    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("a"));
    }

    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        char first = chars[0];

        // 找到第一个字符出现的索引为位置
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == first) {
                res.add(i);
            }
        }

        // 只出现一次
        if (res.size() == 1) {
            return false;
        }
        // 每一个字符都是相同的
        if (res.size() == s.length()) {
            return true;
        }

        for (int i = 1; i < res.size(); i++) {
            if (check(chars, res.get(i) - res.get(0))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否是重复的子串
     *
     * @param num 重复的字串的长度
     */
    private boolean check(char[] chars, int num) {
        int len = chars.length;
        if (len % num != 0) {
            // 不能整除,说明不是
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            // 判断后面的和前面的是否相等
            if (chars[i] != chars[i % num]) {
                return false;
            }
        }
        return true;
    }
}
