package com.db117.example.leetcode.solution4;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/28/028 15:26
 */
public class Solution409 {
    public static void main(String[] args) {
        System.out.println(new Solution409().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        // 统计字符出现的次数
        int[] upper = new int[26];
        int[] lower = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }

        // 是否有单个的
        boolean flag = false;
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (!flag) {
                if (lower[i] % 2 == 1 || upper[i] % 2 == 1) {
                    // 如果有落单的字符
                    flag = true;
                }
            }
            // 成对的个数
            res += lower[i] / 2;
            res += upper[i] / 2;
        }

        return res * 2 + (flag ? 1 : 0);
    }
}
