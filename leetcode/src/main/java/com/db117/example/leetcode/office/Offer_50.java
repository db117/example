//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 67 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 50.第一个只出现一次的字符.di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 * @author db117
 * @since 2021-01-14 14:24:07
 **/

public class Offer_50 {
    public static void main(String[] args) {
        Solution solution = new Offer_50().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return ' ';
            }
            // 统计每个字母出现的次数
            int[] tmp = new int[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                tmp[c - 'a']++;
            }
            for (char c : chars) {
                if (tmp[c - 'a'] == 1) {
                    // 出现一次
                    return c;
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}