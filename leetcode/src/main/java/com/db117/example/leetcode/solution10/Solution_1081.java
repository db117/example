

//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
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
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 95 👎 0


package com.db117.example.leetcode.solution10;

import java.util.Stack;

/**
 * 1081.不同字符的最小子序列.smallest-subsequence-of-distinct-characters
 *
 * @author db117
 * @since 2021-04-29 18:32:35
 **/

public class Solution_1081 {
    public static void main(String[] args) {
        Solution solution = new Solution_1081().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
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