//给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
//
// 子数组是数组中的一个连续数字序列。 
//
// 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi
//+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,20,30,5,10,50]
//输出：65
//解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,20,30,40,50]
//输出：150
//解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [12,17,15,13,10,11,12]
//输出：33
//解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。 
// 
//
// 示例 4： 
//
// 
//输入：nums = [100,10,1]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
// Related Topics 双指针 
// 👍 4 👎 0


package com.db117.example.leetcode.solution18;

/**
 * 1800.最大升序子数组和.maximum-ascending-subarray-sum
 *
 * @author db117
 * @since 2021-03-22 14:21:56
 **/

public class Solution_1800 {
    public static void main(String[] args) {
        Solution solution = new Solution_1800().new Solution();
        System.out.println(solution.maxAscendingSum(new int[]{
                10,20,30,5,10,50
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int left = 0, right = 0, max = -1;

            while (left < nums.length && right < nums.length) {
                // 一直找到非递增
                while (right < nums.length - 1 && nums[right] < nums[right + 1]) {
                    right++;
                }
                // 记录最大和
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                max = Math.max(sum, max);

                // 重置
                left = right + 1;
                right++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}