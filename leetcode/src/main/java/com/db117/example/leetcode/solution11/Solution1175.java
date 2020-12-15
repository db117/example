//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 
// 👍 22 👎 0


package com.db117.example.leetcode.solution11;

/**
 * 1175.质数排列.prime-arrangements
 *
 * @author db117
 * @since 2020-12-15 11:28:20
 **/

public class Solution1175 {
    public static void main(String[] args) {
        Solution solution = new Solution1175().new Solution();
        System.out.println(solution.numPrimeArrangements(11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPrimeArrangements(int n) {
            if (n == 1) {
                return 1;
            }
            // 质数数量
            int num = 1;
            for (int i = 3; i <= n; i++) {
                if (isPrime(i)) {
                    num++;
                }
            }
            // 质数的全排列*非质数的全排列
            return (int) ((helper(num) * helper(n - num)) % 1000000007);
        }


        /**
         * 是否是质数
         */
        private boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        // 阶乘
        public long helper(long n) {
            if (n < 2) {
                return n;
            }
            return (n * helper(n - 1)) % 1000000007;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}