// 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 8 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1790.仅执行一次字符串交换能否使两个字符串相等.check-if-one-string-swap-can-make-strings-equal
 *
 * @author db117
 * @since 2021-04-02 17:32:04
 **/

public class Solution_1790 {
    public static void main(String[] args) {
        Solution solution = new Solution_1790().new Solution();
        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
        System.out.println(solution.areAlmostEqual("kelb", "kelb"));
        System.out.println(solution.areAlmostEqual("aa", "ac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            // 第一个不一样的位置
            int firstIndex = -1;
            // 是否已经有两个位置不一样了
            boolean flag = false;

            int len = s1.length();

            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (firstIndex < 0) {
                        firstIndex = i;
                    } else {
                        if (flag) {
                            // 已经有两个位置不一样了
                            return false;
                        }
                        if (s1.charAt(firstIndex) != s2.charAt(i) ||
                                s1.charAt(i) != s2.charAt(firstIndex)) {
                            // 交换后不一样
                            return false;
                        }
                        flag = true;
                    }
                }
            }
            // 只有一个位置不一样
            if (!flag && firstIndex != -1) {
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}