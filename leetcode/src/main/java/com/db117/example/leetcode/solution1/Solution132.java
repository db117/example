package com.db117.example.leetcode.solution1;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回符合要求的最少分割次数。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/20/020
 */
public class Solution132 {
    public static void main(String[] args) {
        System.out.println(new Solution132().minCut("aabbbbbbbbbbbbbbbb"));
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        int[] dp = new int[len];
        // 都默认设为字符串长度
        Arrays.fill(dp, len - 1);

        for (int i = 0; i < len; i++) {
            // 以当前节点左右扩展
            helper(s, i, i, dp);
            // 以当前节点和下一个节点左右扩展
            helper(s, i, i + 1, dp);
        }

        return dp[len - 1];
    }

    public void helper(String s, int left, int right, int[] dp) {
        // 左右扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 当前区间右边界和当前区间左边界的左边的最小的
            dp[right] = left == 0 ? 0 : Math.min(dp[right], dp[left - 1] + 1);
            left--;
            right++;
        }
    }
}
