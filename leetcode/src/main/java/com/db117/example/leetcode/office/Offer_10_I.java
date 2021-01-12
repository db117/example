


//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 91 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 10- I.斐波那契数列.fei-bo-na-qi-shu-lie-lcof
 *
 * @author db117
 * @since 2021-01-12 10:16:11
 **/

public class Offer_10_I {
    public static void main(String[] args) {
        Solution solution = new Offer_10_I().new Solution();
        System.out.println(solution.fib(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int first = 0, two = 1;
            for (int i = 2; i <= n; i++) {
                two = first + two;
                first = two - first;
                // 取模,防止溢出
                two %= 1000000007;
            }
            return two;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}