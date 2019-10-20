package com.db117.example.leetcode.solution2;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/20/020 15:25
 */
public class Solution258 {
    public int addDigits(int num) {
        // X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)；所以对9取余即可。
        if (num < 10) {
            return num;
        }
        num = num % 9;
        if (num == 0) {
            // 是9的倍数
            return 9;
        }
        return num;
    }
}
