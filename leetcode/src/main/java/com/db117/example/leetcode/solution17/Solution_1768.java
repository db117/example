//给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到
//合并后字符串的末尾。 
//
// 返回 合并后的字符串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "pqr"
//输出："apbqcr"
//解释：字符串合并情况如下所示：
//word1：  a   b   c
//word2：    p   q   r
//合并后：  a p b q c r
// 
//
// 示例 2： 
//
// 
//输入：word1 = "ab", word2 = "pqrs"
//输出："apbqrs"
//解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
//word1：  a   b 
//word2：    p   q   r   s
//合并后：  a p b q   r   s
// 
//
// 示例 3： 
//
// 
//输入：word1 = "abcd", word2 = "pq"
//输出："apbqcd"
//解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
//word1：  a   b   c   d
//word2：    p   q 
//合并后：  a p b q c   d
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 100 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 8 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1768.交替合并字符串.merge-strings-alternately
 *
 * @author db117
 * @since 2021-04-02 18:28:41
 **/

public class Solution_1768 {
    public static void main(String[] args) {
        Solution solution = new Solution_1768().new Solution();
        System.out.println(solution.mergeAlternately("ab", "pqrs"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder ans = new StringBuilder(word1.length() + word2.length());
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            int i1 = 0, i2 = 0, i = 0;
            while (i1 < chars1.length || i2 < chars2.length) {
                // 有一个完事了
                if (i1 >= chars1.length) {
                    ans.append(chars2[i2++]);
                    continue;
                }
                if (i2 >= chars2.length) {
                    ans.append(chars1[i1++]);
                    continue;
                }

                // 都没有完事
                if (i % 2 == 0) {
                    ans.append(chars1[i1++]);
                } else {
                    ans.append(chars2[i2++]);
                }
                i++;
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}