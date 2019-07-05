package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/5
 **/
@Slf4j
public class Solution69 {
    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt(1));
    }

    public int mySqrt(int x) {
        // 左右位置
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            // 二分
            long mid = (right + left) / 2 + 1;
            long s = mid * mid;
            if (s == x) {
                return (int) mid;
            } else if (s < x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }
}
