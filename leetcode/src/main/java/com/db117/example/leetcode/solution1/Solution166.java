package com.db117.example.leetcode.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * <p>
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * <p>
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/12/012 16:55
 */
public class Solution166 {
    public static void main(String[] args) {
        System.out.println(new Solution166().fractionToDecimal(7, -12));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "NaN";
        }
        StringBuilder sb = new StringBuilder();
        // 符号
        if ((numerator ^ denominator) < 0) {
            sb.append("-");
        }
        // 整数
        long left = Math.abs((long) numerator / denominator);
        sb.append(left);
        // 取模
        long mod = Math.abs((long) numerator % denominator);

        // 没有小数
        if (mod == 0) {
            return sb.toString();
        }
        sb.append(".");

        // 余数->出现的位置
        Map<Long, Integer> map = new HashMap<>();
        while (mod != 0) {

            if (map.get(mod) != null) {
                // 找到循环位置
                sb.insert(map.get(mod), "(");
                sb.append(")");
                return sb.toString();
            }
            // 缓存
            map.put(mod, sb.length());
            mod = mod * 10;
            sb.append(Math.abs(mod / denominator));
            mod = mod % denominator;
        }

        return sb.toString();
    }
}
