package com.db117.example.leetcode.solution5;

/**
 * 541. 反转字符串 II
 * <p>
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 * <p>
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/16
 **/

public class Solution541 {
    public static void main(String[] args) {
        System.out.println(new Solution541().reverseStr("abcdefgh", 7));
    }

    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int start = 0;

        // 如果剩余的大于2k
        while (start + k * 2 < len) {
            reverse(chars, start, start + k - 1);
            start += k * 2;
        }

        // 处理剩下的数据
        int i = len - start;
        if (i < k) {
            // 如果剩余少于 k 个字符，则将剩余的所有全部反转
            reverse(chars, start, len - 1);
        } else {
            // 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样
            reverse(chars, start, start + k - 1);
        }

        return new String(chars);
    }

    /**
     * 交换
     *
     * @param chars 数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];

            start++;
            end--;
        }
    }
}
