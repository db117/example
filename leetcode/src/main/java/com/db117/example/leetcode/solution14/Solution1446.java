//给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。 
//
// 请你返回字符串的能量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "leetcode"
//输出：2
//解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
// 
//
// 示例 2： 
//
// 输入：s = "abbcccddddeeeeedcba"
//输出：5
//解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
// 
//
// 示例 3： 
//
// 输入：s = "triplepillooooow"
//输出：5
// 
//
// 示例 4： 
//
// 输入：s = "hooraaaaaaaaaaay"
//输出：11
// 
//
// 示例 5： 
//
// 输入：s = "tourist"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 12 👎 0


package com.db117.example.leetcode.solution14;

/**
 * 1446.连续字符.consecutive-characters
 *
 * @author db117
 * @since 2020-12-21 15:52:18
 **/

public class Solution1446 {
    public static void main(String[] args) {
        Solution solution = new Solution1446().new Solution();
        System.out.println(solution.maxPower("cc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPower(String s) {
            if (s.length() == 1) {
                return 1;
            }
            // 就是最长联系字符串长度
            char[] chars = s.toCharArray();
            char pre = chars[0];
            int max = Integer.MIN_VALUE;
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == pre) {
                    count++;
                } else {
                    // 出现不一样的字符
                    pre = chars[i];
                    max = Math.max(max, count);
                    count = 1;
                }
            }

            // 最后一个联系的字符串
            max = Math.max(max, count);


            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}