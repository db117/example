package com.db117.example.leetcode.solution5;

/**
 * 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/5/24/024 11:50
 */
public class Solution504 {
    public static void main(String[] args) {
        System.out.println(new Solution504().convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            num *= -1;
            flag = true;
        }
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            res.append(num % 7);
            num = num / 7;
        }
        String s = res.reverse().toString();
        return flag ? "-" + s : s;
    }
}
