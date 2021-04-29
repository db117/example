//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 522 👎 0


package com.db117.example.leetcode.solution3;

import java.util.Stack;

/**
 * 316.去除重复字母.remove-duplicate-letters
 *
 * @author db117
 * @since 2021-04-29 15:12:43
 **/

public class Solution_316 {
    public static void main(String[] args) {
        Solution solution = new Solution_316().new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        //bbcaac" 测试结果:"ac" 期望结果:"bac"
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
        // "abacb" 测试结果:"acb" 期望结果:"abc"
        System.out.println(solution.removeDuplicateLetters("abacb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {

            StringBuilder b = new StringBuilder();
            // 记录栈中是否已经有该字符
            boolean[] flag = new boolean[26];
            char[] chars = s.toCharArray();
            // 字符的数量
            int[] tmp = new int[26];
            for (char c : chars) {
                tmp[c - 'a']++;
            }
            // 单调栈
            Stack<Character> stack = new Stack<>();

            for (char c : chars) {
                int n = c - 'a';
                if (stack.isEmpty()) {
                    stack.push(c);
                    flag[n] = true;
                    continue;
                }

                // 删前面比当前字符小的字符
                // 前提是后面还有相同的字符
                while (!stack.isEmpty() &&
                        !flag[n] && // 当前栈中不存在
                        stack.peek() > c && // 栈顶值大于当前值
                        tmp[stack.peek() - 'a'] > 1 // 栈顶的值后面还有
                ) {
                    int i = stack.peek() - 'a';
                    // 剩余数量
                    tmp[i]--;
                    // 标记为未使用
                    flag[i] = false;

                    stack.pop();
                }

                if (flag[n]) {
                    // 栈中有就跳过
                    tmp[n]--;
                } else {
                    // 栈中没有
                    stack.push(c);
                    flag[n] = true;
                }
            }

            for (Character c : stack) {
                b.append(c);
            }
            return b.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}