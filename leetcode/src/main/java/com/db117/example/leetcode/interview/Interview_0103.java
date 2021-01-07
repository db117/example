


//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 
// 👍 25 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 01.03.URL化.string-to-url-lcci
 *
 * @author db117
 * @since 2021-01-07 17:31:24
 **/

public class Interview_0103 {
    public static void main(String[] args) {
        Solution solution = new Interview_0103().new Solution();
        //"ds sdfs afs sdfa dfssf asdf             "
        //27
        //ds ds%20sdfs%20afs%20sdfa%20dfssf%20asdf
        System.out.println(solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String s, int length) {
            StringBuilder res = new StringBuilder(s.length());
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    res.append("%20");
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}