package com.db117.example.leetcode.solution3;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/7/007
 **/
public class Solution394 {
    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        // 把数据放入到
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        StringBuilder number = new StringBuilder();
        String temp;
        for (char c : chars) {
            // 不上]入栈
            if (c != ']') {
                stack.push(c);
            } else {
                // 获取当前字符
                while (stack.peek() != '[') {
                    builder.append(stack.pop());
                }
                temp = builder.reverse().toString();
                stack.pop();

                // 构建当前字符串
                builder.setLength(0);
                // 获取次数
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number.append(stack.pop());
                }
                int num = Integer.parseInt(number.reverse().toString());
                number.setLength(0);
                for (int i = 0; i < num; i++) {
                    builder.append(temp);
                }

                // 放入到栈中
                for (char c1 : builder.toString().toCharArray()) {
                    stack.push(c1);
                }
                builder.setLength(0);
            }
        }

        for (Character c : stack) {
            builder.append(c);
        }

        return builder.toString();
    }
}
