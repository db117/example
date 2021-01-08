


//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 
// 👍 48 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 01.09.字符串轮转.string-rotation-lcci
 *
 * @author db117
 * @since 2021-01-07 18:50:17
 **/

public class Interview_0109 {
    public static void main(String[] args) {
        Solution solution = new Interview_0109().new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            return (s2 + s2).contains(s1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();

            for (int i = 0; i < chars2.length; i++) {
                if (chars1[0] == chars2[i] && helper(chars1, chars2, i)) {
                    return true;
                }
            }

            return false;
        }

        boolean helper(char[] chars1, char[] chars2, int n) {
            for (int i = 0; i < chars1.length; i++) {
                int index2 = i + n;
                if (index2 >= chars1.length) {
                    index2 -= chars1.length;
                }
                if (chars1[i] != chars2[index2]) {
                    return false;
                }
            }
            return true;
        }
    }
}