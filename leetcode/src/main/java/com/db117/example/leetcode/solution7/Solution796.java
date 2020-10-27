//给定两个字符串, A 和 B。 
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，
// 在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。 
//
// 
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false 
//
// 注意： 
//
// 
// A 和 B 长度不超过 100。 
// 
// 👍 106 👎 0

package com.db117.example.leetcode.solution7;

/**
 * 796.旋转字符串.rotate-string
 *
 * @author db117
 * @date 2020-10-27 15:01:09
 **/
public class Solution796 {
    public static void main(String[] args) {
        Solution solution = new Solution796().new Solution();
        System.out.println(solution.rotateString("abcde", "abced"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            if (A.equals(B)) {
                return true;
            }

            char[] aChars = A.toCharArray();
            char[] bChars = B.toCharArray();

            for (int i = 0; i < aChars.length; i++) {
                // 从i开始是否一致
                if (check(aChars, bChars, i)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 校验两个数组是否一致
         *
         * @param k 第二个数组的开始位置
         */
        private boolean check(char[] aChar, char[] bChar, int k) {
            for (int i = 0; i < aChar.length; i++) {
                int j = k + i;
                if (j >= aChar.length) {
                    j = j - aChar.length;
                }

                if (aChar[i] != bChar[j]) {
                    return false;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}