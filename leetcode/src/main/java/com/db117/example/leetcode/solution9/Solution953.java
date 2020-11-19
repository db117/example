//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 fals
//e。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
// 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
// Related Topics 哈希表 
// 👍 61 👎 0


package com.db117.example.leetcode.solution9;

/**
 * 953.验证外星语词典.verifying-an-alien-dictionary
 *
 * @author db117
 * @since 2020-11-19 11:04:31
 **/
public class Solution953 {
    public static void main(String[] args) {
        Solution solution = new Solution953().new Solution();
        System.out.println(solution.isAlienSorted(new String[]{
                "hello", "leetcode"
        }, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAlienSorted(String[] words, String order) {
            // 标识字符的顺序
            int[] sort = new int[26];
            for (int i = 0; i < order.toCharArray().length; i++) {
                char c = order.charAt(i);
                sort[c - 'a'] = i;
            }

            for (int i = 1; i < words.length; i++) {
                if (compare(words[i - 1], words[i], sort) > 0) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 比较
         *
         * @param s1   s1
         * @param s2   s2
         * @param sort 排序索引
         */
        public int compare(String s1, String s2, int[] sort) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int len = Math.max(chars1.length, chars2.length);

            for (int i = 0; i < len; i++) {
                if (i >= chars1.length) {
                    // s1比较短
                    return -1;
                }
                if (i >= chars2.length) {
                    return 1;
                }


                char c1 = chars1[i];
                char c2 = chars2[i];
                if (c1 == c2) {
                    continue;
                }
                // 不相等
                return sort[c1 - 'a'] - sort[c2 - 'a'];
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}