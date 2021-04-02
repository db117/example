// 给你一个二进制字符串 s ，该字符串 不含前导零 。
//
// 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1001"
//输出：false
//解释：字符串中的 1 没有形成一个连续字段。
// 
//
// 示例 2： 
//
// 
//输入：s = "110"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 为 '0' 或 '1' 
// s[0] 为 '1' 
// 
// Related Topics 贪心算法 
// 👍 6 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1784.检查二进制字符串字段.check-if-binary-string-has-at-most-one-segment-of-ones
 *
 * @author db117
 * @since 2021-04-02 17:17:47
 **/

public class Solution_1784 {
    public static void main(String[] args) {
        Solution solution = new Solution_1784().new Solution();
        System.out.println(solution.checkOnesSegment("1001"));
        System.out.println(solution.checkOnesSegment("111100"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkOnesSegment(String s) {
            int i = 0;
            // 找到第一个0
            while (i < s.length() &&
                    s.charAt(i) == '1') {
                i++;

            }

            // 找剩下的第一个1
            while (i < s.length() &&
                    s.charAt(i) == '0') {
                i++;
            }

            return i == s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}