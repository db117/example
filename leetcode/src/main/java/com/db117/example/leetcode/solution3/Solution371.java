package com.db117.example.leetcode.solution3;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/16/016 11:56
 */
public class Solution371 {
    public static void main(String[] args) {
        System.out.println(new Solution371().getSum(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    public int getSum(int a, int b) {
        // 进位
        int top = (a & b) << 1;
        // 不进位的结果
        int sum = a ^ b;
        if (top == 0) {
            // 没有进位
            return sum;
        }
        return getSum(top, sum);
    }
}
