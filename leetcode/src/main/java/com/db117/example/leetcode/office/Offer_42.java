//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 192 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 42.连续子数组的最大和.lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * @author db117
 * @since 2021-01-14 11:32:27
 **/

public class Offer_42 {
    public static void main(String[] args) {
        Solution solution = new Offer_42().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {

            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            int max = dp[0];

            for (int i = 1; i < nums.length; i++) {
                // 当前位置的数字和前面能拿到的最大值之和,和自己比
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}