//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 56 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 05.替换空格.ti-huan-kong-ge-lcof
 *
 * @author db117
 * @since 2021-01-12 19:55:12
 **/

public class Offer_05 {
    public static void main(String[] args) {
        Solution solution = new Offer_05().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            // 空格数量
            int bCount = 0;
            for (char c : chars) {
                if (c == ' ') {
                    bCount++;
                }
            }
            if (bCount == 0) {
                // 没有空格
                return s;
            }

            char[] ans = new char[s.length() + (bCount * 2)];

            int index = 0;
            for (char c : chars) {
                if (c == ' ') {
                    ans[index++] = '%';
                    ans[index++] = '2';
                    ans[index++] = '0';
                } else {
                    ans[index++] = c;
                }
            }

            return new String(ans);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}