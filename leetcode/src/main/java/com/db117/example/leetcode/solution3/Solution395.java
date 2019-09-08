package com.db117.example.leetcode.solution3;

/**
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/6/006 18:22
 */
public class Solution395 {
    public static void main(String[] args) {
        //"bbaaacbd"
        //3
        System.out.println(new Solution395().longestSubstring("bbaaacbd", 3));
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        return helper(s.toCharArray(), 0, s.length() - 1, k);
    }

    private int helper(char[] chars, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }
        // 当前字符子串每一个字符出现的次数
        int[] cs = new int[26];
        for (int i = left; i <= right; i++) {
            cs[chars[i] - 'a']++;
        }

        // 缩小左右指针
        while (right - left + 1 >= k && cs[chars[right] - 'a'] < k) {
            right--;
        }
        while (right - left + 1 >= k && cs[chars[left] - 'a'] < k) {
            left++;
        }

        // 找到肯定不存在的字符
        for (int i = left; i <= right; i++) {
            if (cs[chars[i] - 'a'] < k) {
                // 递归查找子串
                return Math.max(helper(chars, left, i - 1, k), helper(chars, i + 1, right, k));
            }
        }
        // 当当前字符串没有小于k的情况
        return right - left + 1;
    }

}
