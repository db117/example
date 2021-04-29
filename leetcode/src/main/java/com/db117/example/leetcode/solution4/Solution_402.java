//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 559 👎 0


package com.db117.example.leetcode.solution4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402.移掉K位数字.remove-k-digits
 *
 * @author db117
 * @since 2021-04-29 17:00:05
 **/

public class Solution_402 {
    public static void main(String[] args) {
        Solution solution = new Solution_402().new Solution();

        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
        System.out.println(solution.removeKdigits("1234567890", 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            char[] chars = num.toCharArray();
            int tmp = k;

            for (char c : chars) {
                if (deque.isEmpty()) {
                    deque.offer(c);
                    continue;
                }

                // 删除前面比当前字符大的,只删k个
                while (k > 0 &&
                        !deque.isEmpty() &&
                        deque.peekLast() > c) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(c);
            }

            StringBuilder b = new StringBuilder();

            for (int i = 0; i < num.length() - tmp; i++) {
                b.append(deque.pollFirst());
            }

            // 去掉前导0
            while (b.length() > 0 && b.charAt(0) == '0') {
                b.deleteCharAt(0);
            }
            if (b.length() == 0) {
                return "0";
            }
            return b.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}