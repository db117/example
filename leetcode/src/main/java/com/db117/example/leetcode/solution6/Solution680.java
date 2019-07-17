package com.db117.example.leetcode.solution6;

import lombok.extern.slf4j.Slf4j;

/**
 * 680. 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/17
 **/
@Slf4j
public class Solution680 {
    public static void main(String[] args) {
        System.out.println(new Solution680().validPalindrome("a"));
    }

    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        // 不删除字符来一下
        if (isPalindrome(chars, 0, chars.length - 1)) {
            return true;
        }
        int left = 0, right = chars.length - 1;
        // 找到不一样的左右指针
        while (left < right) {
            if (chars[left] != chars[right]) {
                break;
            }
            left++;
            right--;
        }
        // 左跳过试一下
        if (isPalindrome(chars, left + 1, right)) {
            return true;
        }
        // 右跳过试一下
        return isPalindrome(chars, left, right - 1);
    }

    /**
     * 判断是否是回文
     */
    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
