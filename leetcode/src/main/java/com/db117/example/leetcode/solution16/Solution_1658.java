// 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示：
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 1 <= x <= 109 
// 
// Related Topics 贪心算法 双指针 二分查找 Sliding Window 
// 👍 49 👎 0


package com.db117.example.leetcode.solution16;

import java.util.Arrays;

/**
 * 1658.将 x 减到 0 的最小操作数.minimum-operations-to-reduce-x-to-zero
 *
 * @author db117
 * @since 2021-02-20 11:09:43
 **/

public class Solution_1658 {
    public static void main(String[] args) {
        Solution solution = new Solution_1658().new Solution();
        System.out.println(solution.minOperations(new int[]{
                6, 7, 8, 9, 11
        }, 13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int len = nums.length;
            // 滑动窗口
            // 反过来求 sum-x 的区间
            int target = Arrays.stream(nums).sum() - x;
            if (target < 0) {
                return -1;
            }
            if (target == 0) {
                return len;
            }
            int left = 0,
                    right = 0,
                    min = Integer.MAX_VALUE,
                    sum = 0;


            while (left <= right && right <= len) {
                if (sum == target) {
                    min = Math.min(min, len - (right - left));

                    if (right == len) {
                        break;
                    }
                    // 有边界往右边走
                    sum += nums[right++];

                } else if (sum < target) {
                    if (right == len) {
                        break;
                    }
                    // 有边界往右边走
                    sum += nums[right++];

                } else {
                    // 左边界往右边走
                    sum -= nums[left++];
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}