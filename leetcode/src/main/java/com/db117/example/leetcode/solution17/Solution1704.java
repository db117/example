//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。 
//
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
//有大写和小写字母。 
//
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "book"
//输出：true
//解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
// 
//
// 示例 2： 
//
// 输入：s = "textbook"
//输出：false
//解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//注意，元音 o 在 b 中出现两次，记为 2 个。
// 
//
// 示例 3： 
//
// 输入：s = "MerryChristmas"
//输出：false
// 
//
// 示例 4： 
//
// 输入：s = "AbCdEfGh"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 1000 
// s.length 是偶数 
// s 由 大写和小写 字母组成 
// 
// Related Topics 字符串 
// 👍 2 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1704.判断字符串的两半是否相似.determine-if-string-halves-are-alike
 *
 * @author db117
 * @since 2021-01-04 16:23:00
 **/

public class Solution1704 {
    public static void main(String[] args) {
        Solution solution = new Solution1704().new Solution();
        System.out.println(solution.halvesAreAlike("AbCdEfGh"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean halvesAreAlike(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;

            int n = 0;
            for (int i = 0; i < len / 2; i++) {
                if (check(chars[i])) {
                    n++;
                }
            }

            for (int i = len / 2; i < len; i++) {
                if (check(chars[i])) {
                    n--;
                }
            }

            return n == 0;
        }

        boolean check(char c) {
            // 'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'
            return c == 'a' ||
                    c == 'e' ||
                    c == 'i' ||
                    c == 'o' ||
                    c == 'u' ||
                    c == 'A' ||
                    c == 'E' ||
                    c == 'I' ||
                    c == 'O' ||
                    c == 'U';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}