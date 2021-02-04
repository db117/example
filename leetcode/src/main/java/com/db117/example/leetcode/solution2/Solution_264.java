//编写一个程序，找出第 n 个丑数。
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 461 👎 0


package com.db117.example.leetcode.solution2;

/**
 * 264.丑数 II.ugly-number-ii
 *
 * @author db117
 * @since 2021-02-04 10:53:15
 **/

public class Solution_264 {
    public static void main(String[] args) {
        Solution solution = new Solution_264().new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            // 三指针
            // 动态规划先排序在插入
            // 即找三个里面最小的
            int i2 = 1, i3 = 1, i5 = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i2] * 2, dp[i3] * 3);
                dp[i] = Math.min(dp[i], dp[i5] * 5);

                // 去重
                if (dp[i] == dp[i2] * 2) {
                    i2++;
                }
                if (dp[i] == dp[i3] * 3) {
                    i3++;
                }
                if (dp[i] == dp[i5] * 5) {
                    i5++;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}