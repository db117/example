//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，
// 之后返回新的字符串。
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 135 👎 0

package com.db117.example.leetcode.solution7;

/**
 * 709.转换成小写字母.to-lower-case
 *
 * @author db117
 * @date 2020-10-09 15:08:37
 **/
public class Solution709 {
    public static void main(String[] args) {
        Solution solution = new Solution709().new Solution();
        System.out.println(solution.toLowerCase("LOVELY"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toLowerCase(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            StringBuilder builder = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    // 大写转小写
                    builder.append((char) (c + 32));
                } else {
                    builder.append(c);
                }
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}