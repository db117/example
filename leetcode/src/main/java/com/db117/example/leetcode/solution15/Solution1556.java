//给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 987
//输出："987"
// 
//
// 示例 2： 
//
// 输入：n = 1234
//输出："1.234"
// 
//
// 示例 3： 
//
// 输入：n = 123456789
//输出："123.456.789"
// 
//
// 示例 4： 
//
// 输入：n = 0
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n < 2^31 
// 
// Related Topics 字符串 
// 👍 6 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1556.千位分隔数.thousand-separator
 *
 * @author db117
 * @since 2020-12-25 15:06:47
 **/

public class Solution1556 {
    public static void main(String[] args) {
        Solution solution = new Solution1556().new Solution();
        System.out.println(solution.thousandSeparator(1111111));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String thousandSeparator(int n) {
            String s = Integer.toString(n);
            StringBuilder sb = new StringBuilder(s);


            for (int i = s.length() - 1; i > 0; i--) {
                if ((s.length() - i) % 3 == 0) {
                    sb.insert(i, '.');
                }
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}