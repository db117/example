


//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 86 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 53 - I.在排序数组中查找数字 I.zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-14 18:33:59
 **/

public class Offer_53_I {
    public static void main(String[] args) {
        Solution solution = new Offer_53_I().new Solution();
        System.out.println(solution.search(new int[]{
                5, 7, 7, 8, 8, 10
        }, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = bsLeft(nums, target);
            if (left == -1) {
                return 0;
            }
            return bsRight(nums, target) - left + 1;
        }

        // 目标的最左边索引
        int bsLeft(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (mid == 0 || nums[mid - 1] != nums[mid]) {
                        return mid;
                    }
                    right = mid - 1;
                }
            }
            return -1;
        }

        // 目标的最右边索引
        int bsRight(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]) {
                        return mid;
                    }

                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}