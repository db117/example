


//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 字符串 
// 👍 67 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 01.06.字符串压缩.compress-string-lcci
 *
 * @author db117
 * @since 2021-01-07 18:39:28
 **/

public class Interview_0106 {
    public static void main(String[] args) {
        Solution solution = new Interview_0106().new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            if (S.length() < 3) {
                return S;
            }

            StringBuilder res = new StringBuilder();
            char[] chars = S.toCharArray();

            char cur = chars[0];
            int total = 1;
            for (int i = 1, charsLength = chars.length; i < charsLength; i++) {
                char c = chars[i];

                if (c != cur) {
                    res.append(cur).append(total);
                    cur = c;
                    total = 1;
                } else {
                    total++;
                }
            }

            res.append(cur).append(total);

            return res.length() < S.length() ? res.toString() : S;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}