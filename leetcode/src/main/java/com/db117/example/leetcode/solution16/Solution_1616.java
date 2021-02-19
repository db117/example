//给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asu
//ffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bpref
//ix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。 
//
// 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
// "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。 
//
// 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。 
//
// 注意， x + y 表示连接字符串 x 和 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = "x", b = "y"
//输出：true
//解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：a = "abdef", b = "fecab"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：a = "ulacfd", b = "jizalu"
//输出：true
//解释：在下标为 3 处分割：
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。 
//
// 示例 4： 
//
// 
//输入：a = "xbdef", b = "xecab"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 105 
// a.length == b.length 
// a 和 b 都只包含小写英文字母 
// 
// Related Topics 贪心算法 双指针 字符串 
// 👍 27 👎 0


package com.db117.example.leetcode.solution16;

/**
 * 1616.分割两个字符串得到回文串.split-two-strings-to-make-palindrome
 *
 * @author db117
 * @since 2021-02-19 16:25:59
 **/

public class Solution_1616 {
    public static void main(String[] args) {
        Solution solution = new Solution_1616().new Solution();
        //"xbdef"
        //"xecab"
        System.out.println(solution.checkPalindromeFormation("xbdef", "xecab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean checkPalindromeFormation(String a, String b) {
            return check(a, b) || check(b, a);
        }

        boolean check(String a, String b) {
            int len = a.length();
            if (len < 2) {
                return true;
            }
            // 先通过对a顺序,b逆序进行回文匹配
            // 在对剩下的字符进行判断,如果是回文则肯定能拼成回文
            // b顺序,a逆序通过入参调整

            // 先找到a前,b后面是回文的位置
            int left = 0;
            while (left < len / 2) {
                if (a.charAt(left) == b.charAt(len - 1 - left)) {
                    left++;
                } else {
                    break;
                }
            }
            // 如果过半是回文
            if (left == len / 2) {
                return true;
            }

            // 如果剩下的是回文则可以拼成回文
            return helper(a.substring(left, len - left)) || helper(b.substring(left, len - left));
        }

        boolean helper(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}