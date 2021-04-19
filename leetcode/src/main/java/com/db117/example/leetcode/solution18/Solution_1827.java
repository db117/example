// 给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
//
// 
// 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。 
// 
//
// 请你返回使 nums 严格递增 的 最少 操作次数。 
//
// 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1]
// 。一个长度为 1 的数组是严格递增的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1]
//输出：3
//解释：你可以进行如下操作：
//1) 增加 nums[2] ，数组变为 [1,1,2] 。
//2) 增加 nums[1] ，数组变为 [1,2,2] 。
//3) 增加 nums[2] ，数组变为 [1,2,3] 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,2,4,1]
//输出：14
// 
//
// 示例 3： 
//
// 输入：nums = [8]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 1 <= nums[i] <= 104 
// 
// Related Topics 贪心算法 数组 
// 👍 2 👎 0


package com.db117.example.leetcode.solution18;

/**
 * 1827.最少操作使数组递增.minimum-operations-to-make-the-array-increasing
 *
 * @author db117
 * @since 2021-04-19 15:25:27
 **/

public class Solution_1827 {
    public static void main(String[] args) {
        Solution solution = new Solution_1827().new Solution();
        System.out.println(solution.minOperations(new int[]{
                1,2,3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                int numPre = nums[i - 1];
                if (num <= numPre) {
                    // 出现逆序
                    nums[i] = numPre + 1;
                    ans += numPre + 1 - num;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}