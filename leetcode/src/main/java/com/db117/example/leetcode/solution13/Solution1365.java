//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。 
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。 
//
// 以数组形式返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
// 
//
// 示例 2： 
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
// 
//
// 示例 3： 
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 134 👎 0


package com.db117.example.leetcode.solution13;

import java.util.Arrays;

/**
 * 1365.有多少小于当前数字的数字.how-many-numbers-are-smaller-than-the-current-number
 *
 * @author db117
 * @since 2020-12-17 15:58:54
 **/

public class Solution1365 {
    public static void main(String[] args) {
        Solution solution = new Solution1365().new Solution();
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{
                7, 7, 7, 7
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] dp = new int[101];
            // 记录每一个数字出现的次数
            for (int num : nums) {
                dp[num]++;
            }

            // 每一个数字=前面数字出现的次数+当前数字出现的次数
            // 在取的时候找上一个数字即可
            for (int i = 1; i < dp.length; i++) {
                dp[i] += dp[i - 1];
            }

            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                if (nums[i] == 0) {
                    res[i] = 0;
                } else {
                    // 找上一个
                    res[i] = dp[nums[i] - 1];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}