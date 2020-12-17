//给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。 
//
// 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。 
//
// 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。 
//
// 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。 
//
// 
//
// 示例 1： 
//
// 输入：s = "ababa"
//输出：1
//解释：字符串本身就是回文序列，只需要删除一次。
// 
//
// 示例 2： 
//
// 输入：s = "abb"
//输出：2
//解释："abb" -> "bb" -> "". 
//先删除回文子序列 "a"，然后再删除 "bb"。
// 
//
// 示例 3： 
//
// 输入：s = "baabb"
//输出：2
//解释："baabb" -> "b" -> "". 
//先删除回文子序列 "baab"，然后再删除 "b"。
// 
//
// 示例 4： 
//
// 输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// s 仅包含字母 'a' 和 'b' 
// 
// Related Topics 字符串 
// 👍 52 👎 0


package com.db117.example.leetcode.solution13;

/**
 * 1332.删除回文子序列.remove-palindromic-subsequences
 *
 * @author db117
 * @since 2020-12-17 10:41:17
 **/

public class Solution1332 {
    public static void main(String[] args) {
        Solution solution = new Solution1332().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removePalindromeSub(String s) {
            // 脑筋急转弯


            if (s == null || s.length() == 0) {
                return 0;
            }

            // 是回文则删除一次就好
            if (check(new StringBuilder(s))) {
                return 1;
            }

            // 不是回文则先删除a,在删除b
            return 2;
        }

        // 判断是否是回文
        private boolean check(StringBuilder sb) {
            int left = 0, right = sb.length() - 1;
            while (left < right) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}