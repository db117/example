//给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。 
//
//
// 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "011101"
//输出：5 
//解释：
//将字符串 s 划分为两个非空子字符串的可行方案有：
//左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5 
//左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4 
//左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3 
//左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2 
//左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
// 
//
// 示例 2： 
//
// 输入：s = "00111"
//输出：5
//解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 500 
// 字符串 s 仅由字符 '0' 和 '1' 组成。 
// 
// Related Topics 字符串 
// 👍 19 👎 0


package com.db117.example.leetcode.solution14;

/**
 * 1422.分割字符串的最大得分.maximum-score-after-splitting-a-string
 *
 * @author db117
 * @since 2020-12-21 14:40:07
 **/

public class Solution1422 {
    public static void main(String[] args) {
        Solution solution = new Solution1422().new Solution();
        System.out.println(solution.maxScore("101000111010"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(String s) {
            // 1出现的次数
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                }
            }


            // 初始化
            int left, right;
            if (s.charAt(0) == '0') {
                left = 1;
                right = oneCount;
            } else {
                left = 0;
                right = oneCount - 1;
            }

            int max = left + right;
            for (int i = 1; i < s.length() - 1; i++) {
                // 分界点往右移动
                if (s.charAt(i) == '0') {
                    left++;
                } else {
                    right--;
                }
                max = Math.max(max, left + right);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}