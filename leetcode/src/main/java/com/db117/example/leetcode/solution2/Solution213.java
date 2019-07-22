package com.db117.example.leetcode.solution2;

import lombok.extern.slf4j.Slf4j;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/19
 **/
@Slf4j
public class Solution213 {
    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        // 分为两个动态规划,去掉第一个和取取代最后一个
        int n = nums.length;
        // 没有房屋, 直接返回0
        if (nums.length == 0) {
            return 0;
        }
        // 只有一间房屋, 返回该房屋现金
        if (nums.length == 1) {
            return nums[0];
        }

        // 分别把第一个数字和最后一个数字置0 进行第198题的运算
        int first = nums[0];

        nums[0] = 0;
        int max1 = rob1(nums);
        nums[0] = first;
        nums[n - 1] = 0;
        int max2 = rob1(nums);

        return Math.max(max1, max2);
    }

    /**
     * 198题
     */
    public int rob1(int[] nums) {
        // 动态规划,偷 不偷
        // 初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 第二家需要处理一下
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            // 偷
            int in = dp[i - 2] + nums[i];
            // 不偷
            int notIn = dp[i - 1];
            // 取最大
            dp[i] = Math.max(in, notIn);
        }
        return dp[nums.length - 1];
    }
}
