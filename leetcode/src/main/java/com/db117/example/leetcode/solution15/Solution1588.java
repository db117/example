//给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//
// 子数组 定义为原数组中的一个连续子序列。 
//
// 请你返回 arr 中 所有奇数长度子数组的和 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,4,2,5,3]
//输出：58
//解释：所有奇数长度子数组和它们的和为：
//[1] = 1
//[4] = 4
//[2] = 2
//[5] = 5
//[3] = 3
//[1,4,2] = 7
//[4,2,5] = 11
//[2,5,3] = 10
//[1,4,2,5,3] = 15
//我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：3
//解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。 
//
// 示例 3： 
//
// 输入：arr = [10,11,12]
//输出：66
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 
// 👍 26 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1588.所有奇数长度子数组的和.sum-of-all-odd-length-subarrays
 *
 * @author db117
 * @since 2020-12-25 17:01:22
 **/

public class Solution1588 {
    public static void main(String[] args) {
        Solution solution = new Solution1588().new Solution();
        System.out.println(solution.sumOddLengthSubarrays(new int[]{
                1, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            // 记录每个位置出现的次数
            int[] flag = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j <= arr.length; j += 2) {
                    // 当前质数,每个数字出现的最大次数
                    int max = arr.length - j + 1;
                    if (i + 1 < j) {
                        // 当前索引位置小于当前子序列长度,则在该长度下只会出现该索引位置的次数(1开始)
                        flag[i] += Math.min((i + 1), max);
                    } else {
                        // 当前索引(1开始)后面还有的位置,当前子序列长度
                        flag[i] += Math.min(Math.min(arr.length - i, j), max);
                    }

                }
            }

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] * flag[i]);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}