//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 62 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 17.10.主要元素.find-majority-element-lcci
 *
 * @author db117
 * @since 2021-01-22 11:02:05
 **/

public class Interview_1710 {
    public static void main(String[] args) {
        Solution solution = new Interview_1710().new Solution();
        System.out.println(solution.majorityElement(new int[]{
                3, 2, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }
            // 摩尔投票
            int ans = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == ans) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    ans = nums[i];
                    count++;
                }
            }

            // 判断是否是
            int n = (nums.length / 2) + 1;
            count = 0;
            for (int num : nums) {
                if (num == ans) {
                    count++;
                }
                if (count == n) {
                    return ans;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}