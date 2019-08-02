package com.db117.example.leetcode.solution3;


/**
 * 367. 有效的完全平方数
 * <p>
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/2/002
 **/
public class Solution367 {
    public static void main(String[] args) {
        System.out.println(new Solution367().isPerfectSquare1(4));
    }

    public boolean isPerfectSquare1(int num) {
        if (num <= 1) {
            return true;
        }
        // 二分
        int left = 1, right = num >> 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long i = mid * (long) mid;
            if (num == i) {
                return true;
            } else if (num < i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num; i++) {
            int temp = num - i * i;
            if (temp == 0) {
                return true;
            } else if (temp < 0) {
                break;
            }
        }
        return false;
    }
}
