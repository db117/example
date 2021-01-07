


//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 22 👎 0


package com.db117.example.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 01.02.判定是否互为字符重排.check-permutation-lcci
 *
 * @author db117
 * @since 2021-01-07 17:24:30
 **/

public class Interview_0102 {
    public static void main(String[] args) {
        Solution solution = new Interview_0102().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            return Arrays.equals(chars1, chars2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}