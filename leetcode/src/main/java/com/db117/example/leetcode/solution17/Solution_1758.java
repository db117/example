// 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
//
// 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 
//不是。 
//
// 返回使 s 变成 交替字符串 所需的 最少 操作数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "0100"
//输出：1
//解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
// 
//
// 示例 2： 
//
// 输入：s = "10"
//输出：0
//解释：s 已经是交替字符串。
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：2
//解释：需要 2 步操作得到 "0101" 或 "1010" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s[i] 是 '0' 或 '1' 
// 
// Related Topics 贪心算法 数组 
// 👍 14 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1758.生成交替二进制字符串的最少操作数.minimum-changes-to-make-alternating-binary-string
 *
 * @author db117
 * @since 2021-04-02 17:57:54
 **/

public class Solution_1758 {
    public static void main(String[] args) {
        Solution solution = new Solution_1758().new Solution();
        System.out.println(solution.minOperations("0100"));
        System.out.println(solution.minOperations("10"));
        System.out.println(solution.minOperations("1111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String s) {
            char[] chars = s.toCharArray();
            // 改成第一位为1的操作次数
            int one = helper('1', chars);
            // 改成第一位为0的操作次数
            int zero = helper('0', chars);
            return Math.min(one, zero);
        }

        private int helper(char c, char[] chars) {
            int ans = 0;

            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    if (c != chars[i]) {
                        ans++;
                    }
                } else {
                    if (c == chars[i]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}