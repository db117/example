//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
// 示例 1: 
//
// 输入: [1,12,-5,-6,50,3], k = 4
//输出: 12.75
//解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 108 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 643.子数组最大平均数 I
 *
 * @author db117
 * @date 2020-08-26 10:19:13
 **/
public class Solution643 {
    public static void main(String[] args) {
        Solution solution = new Solution643().new Solution();
        System.out.println(solution.findMaxAverage(new int[]{
                1, 12, -5, -6, 50, 3
        }, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            // 滑动窗口
            int start = 0, sum = 0;
            // 初始化
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int max = sum;

            for (int i = k; i < nums.length; i++) {
                // 计算出最大的和
                sum -= nums[i - k];
                sum += nums[i];
                max = Math.max(sum, max);
            }
            return max / (k * 1d);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}