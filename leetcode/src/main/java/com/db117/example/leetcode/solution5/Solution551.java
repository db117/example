//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串 
// 👍 49 👎 0


package com.db117.example.leetcode.solution5;

/**
 * 551.学生出勤记录 I
 *
 * @author db117
 * @date 2020-08-23 18:06:01
 **/
public class Solution551 {
    public static void main(String[] args) {
        Solution solution = new Solution551().new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkRecord(String s) {
            char[] chars = s.toCharArray();
            boolean notA = true;

            int lCount = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == 'A') {
                    if (notA) {
                        notA = false;
                    } else {
                        return false;
                    }
                    lCount = 0;
                }

                if (c == 'P') {
                    lCount = 0;
                }

                if (c == 'L') {
                    lCount++;
                    if (lCount > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}