


//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 35 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 08.01.三步问题.three-steps-problem-lcci
 *
 * @author db117
 * @since 2021-01-11 14:13:39
 **/

public class Interview_0801 {
    public static void main(String[] args) {
        Solution solution = new Interview_0801().new Solution();
        System.out.println(solution.waysToStep(61));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int tmp = 1000000007;

        public int waysToStep(int n) {
            if (n < 3) {
                return n;
            }
            int[] dp = new int[n + 1];
            // 初始数据
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                // 等于前面三个的和
                dp[i] = (dp[i - 1] + dp[i - 2]) % tmp + dp[i - 3];
                // 取模,防止溢出
                dp[i] = dp[i] % tmp;
            }

            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}