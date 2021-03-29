//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
// Related Topics 字符串 
// 👍 2 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1796.字符串中第二大的数字.second-largest-digit-in-a-string
 *
 * @author db117
 * @since 2021-03-29 14:59:49
 **/

public class Solution_1796 {
    public static void main(String[] args) {
        Solution solution = new Solution_1796().new Solution();

        System.out.println(solution.secondHighest("dfa12321afd"));
        System.out.println(solution.secondHighest("abc1111"));
        System.out.println(solution.secondHighest("abc1011"));
        System.out.println(solution.secondHighest("abc1811"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondHighest(String s) {
            int[] tmp = new int[10];
            for (char c : s.toCharArray()) {
                if (c <= '9') {
                    tmp[c - '0']++;
                }
            }

            // 是否找到最大的数字
            boolean flag = false;
            for (int i = tmp.length - 1; i >= 0; i--) {
                if (tmp[i] > 0) {
                    if (flag) {
                        return i;
                    } else {
                        flag = true;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}