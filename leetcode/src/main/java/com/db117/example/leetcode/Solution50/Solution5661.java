//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。 
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。 
//
// 
//
// 示例 1： 
//
// 
//输入：time = "2?:?0"
//输出："23:50"
//解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
// 
//
// 示例 2： 
//
// 
//输入：time = "0?:3?"
//输出："09:39"
// 
//
// 示例 3： 
//
// 
//输入：time = "1?:22"
//输出："19:22"
// 
//
// 
//
// 提示： 
//
// 
// time 的格式为 hh:mm 
// 题目数据保证你可以由输入的字符串生成有效的时间 
// 
// Related Topics 贪心算法 字符串 
// 👍 3 👎 0


package com.db117.example.leetcode.Solution50;

/**
 * Solution.5661.替换隐藏数字得到的最晚时间
 *
 * @author db117
 * @date 2020-10-14 17:47:30
 **/
public class Solution5661 {
    public static void main(String[] args) {
        Solution solution = new Solution5661().new Solution();
        System.out.println(solution.maximumTime("??:??"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumTime(String time) {
            char[] chars = time.toCharArray();
            if (chars[0] == '?') {
                if (chars[1] == '?' || (chars[1] < '4' && chars[1] >= '0')) {
                    chars[0] = '2';
                } else {
                    chars[0] = '1';
                }
            }

            if (chars[1] == '?') {
                chars[1] = (chars[0] == '2') ? '3' : '9';
            }

            if (chars[3] == '?') {
                chars[3] = '5';
            }
            if (chars[4] == '?') {
                chars[4] = '9';
            }
            return new String(chars);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}