package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/16
 **/
@Slf4j
public class Solution32 {
    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("(())()"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = 0, max = 0;
        // 从左往右遍历
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                // 右括号大于左括号则跳过
                left = right = 0;
                continue;
            }
            if (right == left && right > max) {
                // 如果相等,找比较大的值
                max = right;
            }
        }

        // 同理
        left = right = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = right = 0;
                continue;
            }
            if (right == left && right > max) {
                // 如果相等,找比较大的值
                max = right;
            }
        }
        return max * 2;
    }
}
