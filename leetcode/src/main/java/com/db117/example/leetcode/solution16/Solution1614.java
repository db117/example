//如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）： 
//
// 
// 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。 
// 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。 
// 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。 
// 
//
// 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)： 
//
// 
// depth("") = 0 
// depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")" 
// depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串 
// depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串 
// 
//
// 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
// 
//
// 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(1+(2*3)+((8)/4))+1"
//输出：3
//解释：数字 8 在嵌套的 3 层括号中。
// 
//
// 示例 2： 
//
// 
//输入：s = "(1)+((2))+(((3)))"
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "1+(2*3)/(2-1)"
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：s = "1"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成 
// 题目数据保证括号表达式 s 是 有效的括号表达式 
// 
// Related Topics 字符串 
// 👍 9 👎 0


package com.db117.example.leetcode.solution16;

/**
 * 1614.括号的最大嵌套深度.maximum-nesting-depth-of-the-parentheses
 *
 * @author db117
 * @since 2020-12-30 19:57:07
 **/

public class Solution1614 {
    public static void main(String[] args) {

        Solution solution = new Solution1614().new Solution();
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(String s) {
            // 左括号的数量
            int left = 0;
            // 左括号的最大数量
            int max = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                    max = Math.max(left, max);
                }
                if (c == ')') {
                    left--;
                }
            }

            if (left != 0) {
                // 括号没有闭合,则不是合法的
                return -1;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}