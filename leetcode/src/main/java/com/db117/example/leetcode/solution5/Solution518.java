package com.db117.example.leetcode.solution5;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/9/009 17:46
 */
public class Solution518 {
    public static void main(String[] args) {
        System.out.println(new Solution518().change(10, new int[]{
                10
        }));
    }

    public int change(int amount, int[] coins) {
        int len = coins.length;
        // 完全背包
        // 零钱总数->总钱数
        int[][] dp = new int[len + 1][amount + 1];
        // 初始为1
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            // 比当前零钱小的不用考虑
            for (int j = 0; j <= amount; j++) {
                // 货币减去当前零钱的倍数
                for (int k = 0; j - coin * k >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - coin * k];
                }
            }
        }
        return dp[len][amount];
    }
}
