


//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 75 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 58 - II.左旋转字符串.zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * @author db117
 * @since 2021-01-15 10:19:28
 **/

public class Offer_58_II {
    public static void main(String[] args) {
        Solution solution = new Offer_58_II().new Solution();
        //"abcdefg"
        //2
        System.out.println(solution.reverseLeftWords("abcdefg", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            if (s == null || s.length() < 2 || n == 0 || n % s.length() == 0) {
                return s;
            }
            char[] ans = new char[s.length()];
            int index = 0;

            for (int i = 0; i < ans.length; i++) {
                ans[i] = s.charAt((n + i) % ans.length);
            }


            return new String(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}