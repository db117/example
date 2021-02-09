// 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
//
// 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。 
//
// 源数组中可能存在 重复项 。 
//
// 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余
//运算。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：true
//解释：[1,2,3,4,5] 为有序的源数组。
//可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,3,4]
//输出：false
//解释：源数组无法经轮转得到 nums 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：true
//解释：[1,2,3] 为有序的源数组。
//可以轮转 x = 0 个位置（即不轮转）得到 nums 。
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,1]
//输出：true
//解释：[1,1,1] 为有序的源数组。
//轮转任意个位置都可以得到 nums 。
// 
//
// 示例 5： 
//
// 
//输入：nums = [2,1]
//输出：true
//解释：[1,2] 为有序的源数组。
//可以轮转 x = 5 个位置，使新数组从值为 2 的元素开始：[2,1] 。
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
// Related Topics 数组 
// 👍 2 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1752.检查数组是否经排序和轮转得到.check-if-array-is-sorted-and-rotated
 *
 * @author db117
 * @since 2021-02-09 18:47:03
 **/

public class Solution_1752 {
    public static void main(String[] args) {
        Solution solution = new Solution_1752().new Solution();
        System.out.println(solution.check(new int[]{
                2, 1, 3, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean check(int[] nums) {
            if (nums[0] < nums[nums.length - 1]) {
                // 当第一个数字小于最后一个数字,则不能出现递减的情况
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i - 1] > nums[i]) {
                        return false;
                    }
                }
            } else {
                // 当第一个数字大于等于最后一个数字,则可以出现一次递减的情况
                // 是否已经出现了一次递减
                boolean flag = false;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i - 1] > nums[i]) {
                        if (flag) {
                            return false;
                        }
                        flag = true;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}