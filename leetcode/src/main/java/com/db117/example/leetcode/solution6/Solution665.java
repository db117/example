//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 说明： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 342 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 665.非递减数列
 *
 * @author db117
 * @date 2020-09-18 17:23:11
 **/
public class Solution665 {
    public static void main(String[] args) {
        Solution solution = new Solution665().new Solution();
        System.out.println(solution.checkPossibility(new int[]{
                5, 7, 1, 8
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkPossibility(int[] nums) {

            // 是否已经有不递增的了
            boolean flag = false;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (flag) {
                        // 如果第二次出现
                        return false;
                    } else {
                        flag = true;

                        if (i != 0 && nums[i - 1] > nums[i + 1]) {
                            // 前一位大于后一位,使后一位等于当前
                            nums[i + 1] = nums[i];
                        } else {
                            // 前一位小于后一位,这是当前数字等于后一位
                            nums[i] = nums[i + 1];
                        }
                    }
                }

            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}