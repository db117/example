//给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字
//符串 。 
//
// 请你返回 words 数组中 一致字符串 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//输出：2
//解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
// 
//
// 示例 2： 
//
// 
//输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//输出：7
//解释：所有字符串都是一致的。
// 
//
// 示例 3： 
//
// 
//输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//输出：4
//解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 104 
// 1 <= allowed.length <= 26 
// 1 <= words[i].length <= 10 
// allowed 中的字符 互不相同 。 
// words[i] 和 allowed 只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 4 👎 0


package com.db117.example.leetcode.solution16;

/**
 * 1684.统计一致字符串的数目.count-the-number-of-consistent-strings
 *
 * @author db117
 * @since 2021-01-04 14:57:57
 **/

public class Solution1684 {
    public static void main(String[] args) {
        Solution solution = new Solution1684().new Solution();
        System.out.println(solution.countConsistentStrings("cad", new String[]{
                "cc", "acd", "b", "ba", "bac", "bad", "ac", "d"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            // 记录出现的字符
            int[] temp = new int[26];
            for (int i = 0; i < allowed.length(); i++) {
                temp[allowed.charAt(i) - 'a']++;
            }

            int ans = 0;
            for (String word : words) {
                boolean flag = true;
                for (int i = 0; i < word.length(); i++) {
                    if (temp[word.charAt(i) - 'a'] == 0) {
                        // 有没有的字符
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}