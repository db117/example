package com.db117.example.leetcode.solution1;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/5/005
 **/
public class Solution150 {
    public static void main(String[] args) {
        System.out.println(new Solution150().evalRPN(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        }));
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int one = 0, two = 0;

        for (String token : tokens) {

            // 运算
            switch (token) {
                case "+":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(one + two);
                    break;
                case "-":
                    // 减是逆序
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two - one);
                    break;
                case "*":
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(one * two);
                    break;
                case "/":
                    // 减是逆序
                    one = stack.pop();
                    two = stack.pop();
                    stack.push(two / one);
                    break;
                default:
                    // 放入栈
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
