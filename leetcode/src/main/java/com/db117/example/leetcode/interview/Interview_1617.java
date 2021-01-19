//给定一个整数数组，找出总和最大的连续数列，并返回总和。
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 63 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 16.17.连续数列.contiguous-sequence-lcci
 *
 * @author db117
 * @since 2021-01-19 14:48:50
 **/

public class Interview_1617 {
    public static void main(String[] args) {
        Solution solution = new Interview_1617().new Solution();
        System.out.println(solution.maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];

            // 贪心
            // 每个位置为结束位置是最大的和
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(nums[i], nums[i] + sum);
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}