package com.db117.example.leetcode.solution7;

/**
 * \
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * <p>
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 * <p>
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/25/025
 **/

public class Solution724 {
    public static void main(String[] args) {
        System.out.println(new Solution724().pivotIndex1(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        // 求右边的和
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + nums[i + 1];
        }
        // 从左边遍历
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                sum += nums[i - 1];
            }
            if (sum == dp[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        // 第二位 0->左边的和 1->右边的和
        int[][] dp = new int[len][2];
        // 求左边和和
        for (int i = 1; i < len; i++) {
            dp[i][0] = nums[i - 1] + dp[i - 1][0];
        }
        // 求右边的和
        for (int i = len - 2; i >= 0; i--) {
            dp[i][1] = dp[i + 1][1] + nums[i + 1];
        }
        // 从左往右对比
        for (int i = 0; i < len; i++) {
            if (dp[i][0] == dp[i][1]) {
                return i;
            }
        }
        return -1;
    }
}
