package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/13
 **/
@Slf4j
public class Solution29 {
    public static void main(String[] args) {
        System.out.println(new Solution29().divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(-1021989372 / -82778243);

    }

    // 心累
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        // 特殊处理
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MAX_VALUE) {
            return -1;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        // 正负
        boolean sign = dividend > 0 ^ divisor < 0;
        int res = 0;
        // 绝对值
        int left = Math.abs(dividend);
        // 最小值的绝对值是本身
        if (dividend == Integer.MIN_VALUE) {
            left = Integer.MAX_VALUE;
        }
        int right = Math.abs(divisor);
        // 溢出
        if (left == Integer.MAX_VALUE && right == 1) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (left < right) {
            return 0;
        }

        for (int i = 31; i >= 0; i--) {
            // 一直找到能被减去的最大值
            int tem = right << i;
            if (left >> i >= right) {
                left = left - tem;
                res += (1 << i);
            }
        }
        // 当去绝对值溢出是 +1继续计算
        if (dividend == Integer.MIN_VALUE) {
            res = res + divide(left + 1, right);
        }
        return sign ? res : 0 - res;
    }
}
