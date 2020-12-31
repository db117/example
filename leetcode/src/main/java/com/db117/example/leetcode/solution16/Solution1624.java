//给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aa"
//输出：0
//解释：最优的子字符串是两个 'a' 之间的空子字符串。 
//
// 示例 2： 
//
// 输入：s = "abca"
//输出：2
//解释：最优的子字符串是 "bc" 。
// 
//
// 示例 3： 
//
// 输入：s = "cbzxy"
//输出：-1
//解释：s 中不存在出现出现两次的字符，所以返回 -1 。
// 
//
// 示例 4： 
//
// 输入：s = "cabbac"
//输出：4
//解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// s 只含小写英文字母 
// 
// Related Topics 字符串 
// 👍 8 👎 0


package com.db117.example.leetcode.solution16;

import java.util.Arrays;

/**
 * 1624.两个相同字符之间的最长子字符串.largest-substring-between-two-equal-characters
 *
 * @author db117
 * @since 2020-12-31 15:32:41
 **/

public class Solution1624 {
    public static void main(String[] args) {
        Solution solution = new Solution1624().new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            // 统计每一个字符出现的最大,最小位置
            int[] min = new int[26];
            int[] max = new int[26];
            Arrays.fill(min, Integer.MAX_VALUE);
            Arrays.fill(max, Integer.MIN_VALUE);

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                min[index] = Math.min(min[index], i);
                max[index] = Math.max(max[index], i);
            }

            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (min[i] < max[i]) {
                    // 当最小位置小于最大位置说明有符合题意的字符串
                    ans = Math.max(ans, max[i] - min[i]);
                }
            }

            return ans - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}