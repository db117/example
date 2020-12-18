//给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。 
//
// 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。 
//
// 
//
// 示例 1： 
//
// 输入：n = 13
//输出：4
//解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
//[1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：2
//解释：总共有 2 个大小为 1 的组 [1]，[2]。
// 
//
// 示例 3： 
//
// 输入：n = 15
//输出：6
// 
//
// 示例 4： 
//
// 输入：n = 24
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^4 
// 
// Related Topics 数组 
// 👍 15 👎 0


package com.db117.example.leetcode.solution13;

/**
 * 1399.统计最大组的数目.count-largest-group
 *
 * @author db117
 * @since 2020-12-18 17:39:35
 **/

public class Solution1399 {
    public static void main(String[] args) {
        Solution solution = new Solution1399().new Solution();
        System.out.println(solution.countLargestGroup(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countLargestGroup(int n) {
            // 最大为9999 即最多有36个组
            int[] tmp = new int[37];

            // 最大组数
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                // 位数数字之和
                int count = count(i);
                tmp[count]++;
                max = Math.max(tmp[count], max);
            }

            // 找跟最大值相同的个数
            int res = 0;
            for (int i : tmp) {
                if (i == max) {
                    res++;
                }
            }
            return res;
        }

        private int count(int n) {
            int ans = 0;

            while (n > 0) {
                ans += n % 10;
                n = n / 10;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}