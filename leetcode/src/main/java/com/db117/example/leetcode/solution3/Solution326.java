package com.db117.example.leetcode.solution3;

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/23/023
 **/

public class Solution326 {
    public static void main(String[] args) {
        System.out.println(new Solution326().isPowerOfThree1(0));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n % 3 != 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        // 转为3进制的数字,如果不是10...的就不是3的幂
        return Integer.toString(n, 3).matches("10*");
    }
}
