// 累加数是一个字符串，组成它的数字可以形成累加序列。
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。 
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 示例 1: 
//
// 输入: "112358"
//输出: true 
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2: 
//
// 输入: "199100199"
//输出: true 
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 进阶: 
//你如何处理一个溢出的过大的整数输入? 
// Related Topics 回溯算法 
// 👍 160 👎 0


package com.db117.example.leetcode.solution3;

/**
 * 306.累加数.additive-number
 *
 * @author db117
 * @since 2021-05-07 11:44:07
 **/

public class Solution_306 {
    public static void main(String[] args) {
        Solution solution = new Solution_306().new Solution();
        System.out.println(solution.isAdditiveNumber("112358112358224716"));
        System.out.println(solution.isAdditiveNumber("199100199"));
        System.out.println(solution.isAdditiveNumber("101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAdditiveNumber(String num) {
            return dfs(num.toCharArray(), 0, 0, 0, 0);
        }

        /**
         * 深度优先
         *
         * @param chars 字符串
         * @param index 当前数字开始位置
         * @param pre   前一个数字
         * @param sum   前面两个数字和
         * @param count 已经处理的数字数量
         * @return boolean
         */
        public boolean dfs(char[] chars, int index, long pre, long sum, int count) {
            if (index >= chars.length) {
                // 结束条件
                return count > 2;
            }
            for (int i = index; i < chars.length; i++) {
                long cur = helper(chars, index, i);
                // 字符越界
                if (cur < 0) {
                    continue;
                }

                // 和不等于当前数字
                if (count >= 2 && sum != cur) {
                    continue;
                }

                // 递归
                if (dfs(chars, i + 1, cur, cur + pre, count + 1)) {
                    return true;
                }
            }

            return false;
        }

        public long helper(char[] chars, int left, int right) {
            if (left < 0 || right >= chars.length) {
                return -1;
            }
            // 不能是0开头
            if (left < right && chars[left] == '0') {
                return -1;
            }

            long ans = 0;
            for (int i = left; i <= right; i++) {
                ans *= 10;
                ans += chars[i] - '0';
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}