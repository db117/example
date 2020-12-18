//给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。 
//
// 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。 
//
// 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-3,2,-3,4,2]
//输出：5
//解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
//                累加求和
//                startValue = 4 | startValue = 5 | nums
//                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2]
//输出：1
//解释：最小的 startValue 需要是正数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-2,-3]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 17 👎 0


package com.db117.example.leetcode.solution14;

/**
 * 1413.逐步求和得到正数的最小值.minimum-value-to-get-positive-step-by-step-sum
 *
 * @author db117
 * @since 2020-12-18 18:27:13
 **/

public class Solution1413 {
    public static void main(String[] args) {
        Solution solution = new Solution1413().new Solution();
        System.out.println(solution.minStartValue(new int[]{
                -3, 2, -3, 4, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            // 依次加和的最小值
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int num : nums) {
                sum += num;
                min = Math.min(sum, min);
            }
            // 和都大于0则为1
            return min > 0 ? 1 : 1 - min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}