


//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 94 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 53 - II.0～n-1中缺失的数字.que-shi-de-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-15 11:07:08
 **/

public class Offer_53_II {
    public static void main(String[] args) {
        Solution solution = new Offer_53_II().new Solution();
        System.out.println(solution.missingNumber(new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 9
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left >> 1);
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else if (nums[mid] > mid) {
                    right = right - 1;
                }
                // 不存在 num[mid]<mid 的情况
            }
            return left;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public int missingNumber(int[] nums) {
            // a^a=0
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                // 除了那个没有出现的数字,其他数字都出现了两次
                ans ^= i + 1;
                ans ^= nums[i];
            }

            return ans;
        }
    }
}