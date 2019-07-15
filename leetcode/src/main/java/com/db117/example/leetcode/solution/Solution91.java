package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/10
 **/
@Slf4j
public class Solution91 {
    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("121200326"));
    }

    public int numDecodings(String s) {
        // 第一位不能为0
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        // 每一位可能的解码方法的总数
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (c != '0') {
                // 只要前一位不为0,则当前位数量等于前一位
                dp[i] = dp[i - 1];
            }
            // 前两位数字是否在0-26之间,如果在则需要加上i-2位的数量
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
