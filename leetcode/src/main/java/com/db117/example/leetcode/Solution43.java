package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/20
 **/
@Slf4j
public class Solution43 {
    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("5", "12"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ints = new int[len1 + len2];

        // 计算
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                // 把计算结果保存在对应位置
                ints[(len1 - i - 1) + (len2 - j - 1)] += (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
            }
        }
        StringBuilder res = new StringBuilder();
        // 如果当前位置数字大于0,则进位
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] >= 10) {
                ints[i + 1] += ints[i] / 10;
                ints[i] = ints[i] % 10;
            }
            res.append(ints[i]);
        }

        // 如果第一个不是0,则添加
        if (ints[ints.length - 1] != 0) {
            res.append(ints[ints.length - 1]);
        }

        // 翻转
        return res.reverse().toString();
    }
}
