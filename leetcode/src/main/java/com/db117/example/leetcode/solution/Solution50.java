package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/24
 **/
@Slf4j
public class Solution50 {
    public static void main(String[] args) {
        System.out.println(new Solution50().myPow2(2.0, 2));
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            // 如果幂为负数
            x = 1 / x;
            n = -n;
        }

        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            // 结束
            return 1;
        }

        double pow = pow(x, n / 2);

        if (n % 2 == 0) {
            // 如果为偶数
            return pow * pow;
        } else {
            // 奇数
            return pow * pow * x;
        }
    }

    // 循环
    public double myPow2(double x, int n) {
        if (n < 0) {
            //
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        double cur = x;
        int index = n;

        while (index > 0) {
            if ((index % 2) == 1) {
                // 当n为奇数时,把多余的1单拉出来乘
                res = res * cur;
            }
            // 如果index==1时,一下无效
            cur = cur * cur;
            index = index / 2;
        }
        return res;
    }
}
