//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 234 👎 0


package com.db117.example.leetcode.solution8;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 844.比较含退格的字符串.backspace-string-compare
 *
 * @author db117
 * @since 2020-11-06 10:18:10
 **/

public class Solution844 {
    public static void main(String[] args) {
        Solution solution = new Solution844().new Solution();
        // "ab#c"
        //"ad#c"
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            if (S.equals(T)) {
                return true;
            }

            Deque<Character> sQ = new LinkedList<>();
            Deque<Character> tQ = new LinkedList<>();
            // 把字符串走完,的到最终的字符串
            help(sQ, S);
            help(tQ, T);

            if (sQ.size() != tQ.size()) {
                return false;
            }

            // 对比两个栈看是否一致
            while (!sQ.isEmpty()) {
                if (!sQ.poll().equals(tQ.poll())) {
                    return false;
                }
            }
            return true;
        }

        public void help(Deque<Character> queue, String s) {
            for (char c : s.toCharArray()) {
                if (c == '#') {
                    if (!queue.isEmpty()) {
                        queue.pollLast();
                    }
                } else {
                    queue.offerLast(c);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}