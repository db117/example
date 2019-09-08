package com.db117.example.leetcode.solution3;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/8/008 17:06
 */
public class Solution322 {
    public static void main(String[] args) {
        System.out.println(new Solution322().coinChange(new int[]{
                1, 2, 5
        }, 0));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 金额为0,返回0
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    // 当前金额-当前零钱找的情况下
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        // 是否找到
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
