package com.db117.example.leetcode.solution5;

/**
 * 507. 完美数
 * 对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * <p>
 * 给定一个整数n，如果他是完美数，返回True，否则返回False
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数字n 不会超过 100,000,000. (1e8)
 * <p>
 * 通过次数16,494提交次数43,065
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/8/11/011 11:50
 **/
public class Solution507 {
    public static void main(String[] args) {
        Solution507 solution = new Solution507();
        for (int i = 0; i < 10000000; i++) {
            if (solution.checkPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        // 开跟
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0 && i * i != num) {
                sum += i + num / i;
            }
        }
        return sum == num;
    }
}
