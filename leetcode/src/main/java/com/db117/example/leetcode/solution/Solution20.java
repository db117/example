package com.db117.example.leetcode.solution;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/10
 **/

public class Solution20 {
    public static void main(String[] args) {
        System.out.println(new Solution20().isValid2("([)"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // 到着遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            // 右括号进栈
            if (c == ')' || c == ']' || c == '}') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    Character peek = stack.peek();
                    // 如果为对应的左括号出栈
                    if ((c == '(' && peek == ')')
                            || (c == '[' && peek == ']')
                            || (c == '{' && peek == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        while (s.contains("[]") || s.contains("()") || s.contains("{}")) {
            s = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
        }
        return s.length() == 0;
    }
}
