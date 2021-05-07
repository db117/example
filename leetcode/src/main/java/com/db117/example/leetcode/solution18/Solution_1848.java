//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == t
//arget 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。 
//
// 返回 abs(i - start) 。 
//
// 题目数据保证 target 存在于 nums 中。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5], target = 5, start = 3
//输出：1
//解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1, start = 0
//输出：0
//解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
//输出：0
//解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 104 
// 0 <= start < nums.length 
// target 存在于 nums 中 
// 
// Related Topics 数组 
// 👍 0 👎 0


package com.db117.example.leetcode.solution18;

/**
 * 1848.到目标元素的最小距离.minimum-distance-to-the-target-element
 *
 * @author db117
 * @since 2021-05-07 10:47:16
 **/

public class Solution_1848 {
    public static void main(String[] args) {
        Solution solution = new Solution_1848().new Solution();
        System.out.println(solution.getMinDistance(new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        }, 1, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {

            // 从start开始往两边走
            int left = start, right = start;
            while (left >= 0 || right < nums.length) {
                if (left >= 0 && nums[left] == target) {
                    return start - left;
                }

                if (right < nums.length && nums[right] == target) {
                    return right - start;
                }
                left--;
                right++;
            }
            // 走不到这
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}