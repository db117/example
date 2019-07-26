package com.db117.example.leetcode.solution1;

import java.util.Stack;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/26/026
 **/
public class Solution151 {
    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ' ' && c != '\u00a0') {
                // 不为空添加进去
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    // 放入栈中
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        // 还有没有结束的放入栈中
        if (sb.length() != 0) {
            stack.push(sb.toString());
            sb.setLength(0);
        }

        // 出栈
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
