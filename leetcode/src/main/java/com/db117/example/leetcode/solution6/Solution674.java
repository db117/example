//给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
//
// 
//
// 示例 1: 
//
// 输入: [1,3,5,4,7]
//输出: 3
//解释: 最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
// 
//
// 示例 2: 
//
// 输入: [2,2,2,2,2]
//输出: 1
//解释: 最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 注意：数组长度不会超过10000。 
// Related Topics 数组 
// 👍 112 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 674.最长连续递增序列
 *
 * @author db117
 * @date 2020-09-22 17:32:22
 **/
public class Solution674 {
    public static void main(String[] args) {
        Solution solution = new Solution674().new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{
                1, 3, 5, 4, 7
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int /*最大值*/max = Integer.MIN_VALUE, /*计数*/count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] < nums[i]) {
                    // 递增累加
                    count++;
                } else {
                    // 非递增重置数据
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            return Math.max(max, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}