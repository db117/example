package com.db117.example.leetcode.solution2;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/2/00213:56
 */
public class Solution227 {
    public static void main(String[] args) {
        System.out.println(new Solution227().calculate("0-2147483647"));
    }

    /**
     * 把-改为+,* /直接运算,放入栈中
     * 并保存好上一个操作符
     */
    public int calculate(String s) {
        // 都转为+ 乘除直接算完放进去
        Stack<Long> stack = new Stack<>();
        long num = 0;
        // 上一个运算符
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 是数字累加,数字不是一位
            if (c >= '0') {
                num = (c - '0') + num * 10;
            }
            if (c == ' ' && i < s.length() - 1) {
                // 当不上最后一个字符,且为空格时不执行操作
                continue;
            }
            // 不为空或者是最后一个字符
            if (c < '0' || i == s.length() - 1) {
                // 执行运算
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                }
                // 重置数字
                num = 0;
                // 设置为当前操作符
                op = c;
            }
        }


        // 把所以数字加起来
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        return (int) num;
    }
}
