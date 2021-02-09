// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 439 👎 0


package com.db117.example.leetcode.solution3;

/**
 * 343.整数拆分.integer-break
 *
 * @author db117
 * @since 2021-02-09 15:52:38
 **/

public class Solution_343 {
    public static void main(String[] args) {
        Solution solution = new Solution_343().new Solution();
        System.out.println(solution.integerBreak(58));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            // 当每一份越平均则越大,即最大最小值差为1

            // 分成几份
            int k = 2;
            // 最大值
            int max = 1;
            while (k < n) {
                // 分成k分后的乘积
                int tmp = 1;
                // 每份的值
                int j = n / k;
                // 多出来的
                int x = n % k;

                for (int i = 0; i < k; i++) {
                    // 保证最大的数字和最小的数字只差为1
                    if (x == 0) {
                        tmp *= j;
                    } else {
                        tmp *= j + 1;
                        x--;
                    }
                }

                if (tmp >= max) {
                    max = tmp;
                } else {
                    // 开始减小时,则不会出现更大的值
                    return max;
                }
                k++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}