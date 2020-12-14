//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 递归 
// 👍 54 👎 0


package com.db117.example.leetcode.solution11;

/**
 * 1137.第 N 个泰波那契数.n-th-tribonacci-number
 *
 * @author db117
 * @since 2020-12-14 15:30:32
 **/

public class Solution1137 {
    public static void main(String[] args) {
        Solution solution = new Solution1137().new Solution();
        System.out.println(solution.tribonacci(25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int[] temp = new int[n + 3];
            temp[0] = 0;
            temp[1] = 1;
            temp[2] = 1;
            for (int i = 0; i < n; i++) {
                temp[i + 3] = temp[i] + temp[i + 1] + temp[i + 2];
            }
            return temp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}