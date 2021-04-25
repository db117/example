// 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
//
// 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 34, k = 6
//输出：9
//解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
// 
//
// 示例 2： 
//
// 
//输入：n = 10, k = 10
//输出：1
//解释：n 本身就是 10 进制。 1 + 0 = 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 2 <= k <= 10 
// 
// Related Topics 位运算 数学 
// 👍 2 👎 0


package com.db117.example.leetcode.Solution50;

/**
 * 5738.K 进制表示下的各位数字总和.sum-of-digits-in-base-k
 *
 * @author db117
 * @since 2021-04-25 14:46:56
 **/

public class Solution_5738 {
    public static void main(String[] args) {
        Solution solution = new Solution_5738().new Solution();
        System.out.println(solution.sumBase(34, 6));
        System.out.println(solution.sumBase(10, 10));
        System.out.println(solution.sumBase(1, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumBase(int n, int k) {
            int ans = 0;
            while (n != 0) {
                ans += n % k;
                n /= k;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}