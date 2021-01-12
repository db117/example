//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 106 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 10- II.青蛙跳台阶问题.qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * @author db117
 * @since 2021-01-12 10:48:43
 **/

public class Offer_10_II {
    public static void main(String[] args) {

        Solution solution = new Offer_10_II().new Solution();
        System.out.println(solution.numWays(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n) {

            if (n < 2) {
                return 1;
            }
            int first = 1, two = 1;
            for (int i = 2; i <= n; i++) {
                two = two + first;
                first = two - first;

                two %= 1000000007;
            }
            return two;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}