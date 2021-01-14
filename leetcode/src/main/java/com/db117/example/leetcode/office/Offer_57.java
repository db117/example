


//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 66 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 57.和为s的两个数字.he-wei-sde-liang-ge-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-14 15:00:32
 **/

public class Offer_57 {
    public static void main(String[] args) {
        Solution solution = new Offer_57().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 双指针
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }
            return new int[0];
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            for (int num : nums) {
                if (bs(nums, target - num) != -1) {
                    return new int[]{num, target - num};
                }
            }
            return new int[0];
        }

        int bs(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    // [mid+1,right]
                    left = mid + 1;
                } else {
                    // [left,mid-1]
                    right = mid - 1;
                }

            }
            return -1;
        }
    }
}