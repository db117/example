//给你一个整数数组 nums 。 
//
// 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。 
//
// 返回好数对的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,1,1,3]
//输出：4
//解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
// 
//
// 示例 2： 
//
// 输入：nums = [1,1,1,1]
//输出：6
//解释：数组中的每组数字都是好数对 
//
// 示例 3： 
//
// 输入：nums = [1,2,3]
//输出：0
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
// Related Topics 数组 哈希表 数学 
// 👍 46 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1512.好数对的数目.number-of-good-pairs
 *
 * @author db117
 * @since 2020-12-22 18:01:56
 **/

public class Solution1512 {
    public static void main(String[] args) {
        Solution solution = new Solution1512().new Solution();
        System.out.println(solution.numIdenticalPairs(new int[]{
                1, 2, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int[] temp = new int[101];
            // 统计出现的次数
            for (int num : nums) {
                temp[num]++;
            }
            int ans = 0;
            for (int i : temp) {
                if (i > 1) {
                    // 有多个额算组合数
                    ans += helper(i - 1);
                }
            }
            return ans;
        }

        // 1+2+...n
        private int helper(int n) {
            if (n % 2 == 0) {
                return (1 + n) * (n / 2);
            }

            return helper(n - 1) + n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}