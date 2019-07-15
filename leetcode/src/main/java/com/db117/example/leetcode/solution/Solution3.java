package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author db117
 * @date 2019/5/10
 **/
@Slf4j
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, n = s.length();
        while (left < n && right < n) {
            if (!set.contains(chars[right])) {
                // 如果集合没有中有右边的字符,则放入集合
                set.add(chars[right]);
                right++;
                // 比较一下最大值
                max = Math.max(max, right - left);
            } else {
                // 如果集合中有右边字符则,删除左边字符,继续
                set.remove(chars[left]);
                left++;
            }
        }
        return max;
    }
}
