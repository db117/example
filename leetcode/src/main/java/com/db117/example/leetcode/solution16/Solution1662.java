//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 103 
// 1 <= word1[i].length, word2[i].length <= 103 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 103 
// word1[i] 和 word2[i] 由小写字母组成 
// 
// Related Topics 字符串 
// 👍 5 👎 0


package com.db117.example.leetcode.solution16;

/**
 * 1662.检查两个字符串数组是否相等.check-if-two-string-arrays-are-equivalent
 *
 * @author db117
 * @since 2021-01-04 14:33:56
 **/

public class Solution1662 {
    public static void main(String[] args) {
        Solution solution = new Solution1662().new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{
                "a", "bc"
        }, new String[]{
                "ab", "c"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            // 两个数组以及字符串的位置
            int w1 = 0, ws1 = 0, w2 = 0, ws2 = 0;

            while (w1 < word1.length) {

                if (word1[w1].charAt(ws1) != word2[w2].charAt(ws2)) {
                    // 不相等
                    return false;
                }
                // 调整索引
                ws1++;
                if (ws1 == word1[w1].length()) {
                    ws1 = 0;
                    w1++;
                }
                ws2++;
                if (ws2 == word2[w2].length()) {
                    ws2 = 0;
                    w2++;
                }

                // 校验索引
                if (w1 == word1.length && w2 == word2.length) {
                    // 刚好都结束
                    return true;
                }
                if (w1 == word1.length || w2 == word2.length) {
                    // 有一个结束,有一个没有结束
                    return false;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}