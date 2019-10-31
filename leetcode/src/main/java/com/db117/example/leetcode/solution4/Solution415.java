package com.db117.example.leetcode.solution4;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/31/031 10:19
 */
public class Solution415 {
    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("999999", "1564785448"));
    }

    public String addStrings(String num1, String num2) {
        int len = Math.max(num1.length(), num2.length());
        // 每一位都加起来
        int[] ints = new int[len + 1];
        int index = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            ints[index++] += num1.charAt(i) - '0';
        }
        index = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            ints[index++] += num2.charAt(i) - '0';
        }
        // 进位
        for (int i = 0; i < len; i++) {
            while (ints[i] > 9) {
                ints[i] -= 10;
                ints[i + 1]++;
            }
        }

        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        if (ints[len] != 0) {
            sb.append(ints[len]);
        }

        for (int i = len - 1; i >= 0; i--) {
            sb.append(ints[i]);
        }
        return sb.toString();
    }
}
