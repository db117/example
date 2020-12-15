//给你一个字符串 date ，它的格式为 Day Month Year ，其中： 
//
// 
// Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。 
// Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oc
//t", "Nov", "Dec"} 中的一个元素。 
// Year 的范围在 [1900, 2100] 之间。 
// 
//
// 请你将字符串转变为 YYYY-MM-DD 的格式，其中： 
//
// 
// YYYY 表示 4 位的年份。 
// MM 表示 2 位的月份。 
// DD 表示 2 位的天数。 
// 
//
// 
//
// 示例 1： 
//
// 输入：date = "20th Oct 2052"
//输出："2052-10-20"
// 
//
// 示例 2： 
//
// 输入：date = "6th Jun 1933"
//输出："1933-06-06"
// 
//
// 示例 3： 
//
// 输入：date = "26th May 1960"
//输出："1960-05-26"
// 
//
// 
//
// 提示： 
//
// 
// 给定日期保证是合法的，所以不需要处理异常输入。 
// 
// Related Topics 字符串 
// 👍 5 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1507.转变日期格式.reformat-date
 *
 * @author db117
 * @since 2020-12-15 15:27:34
 **/

public class Solution1507 {
    public static void main(String[] args) {
        Solution solution = new Solution1507().new Solution();
        System.out.println(solution.reformatDate("20th Oct 2052"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformatDate(String date) {
            String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            String[] split = date.split(" ");
            String day = split[0];
            String month = split[1];
            String year = split[2];
            StringBuilder res = new StringBuilder();
            // 年
            res.append(year);
            res.append('-');

            // 月
            for (int i = 0; i < months.length; i++) {
                String s = months[i];
                if (s.equals(month)) {
                    res.append(i + 1);
                }
            }
            // 补0
            if (res.length() == 6) {
                res.insert(5, "0");
            }
            res.append('-');

            // 日
            res.append(day);
            for (int i = 8; i < res.length(); i++) {
                // 日不是数字直接删掉
                if (!Character.isDigit(res.charAt(i))) {
                    res.delete(i, res.length());
                    break;
                }
            }
            // 补0
            if (res.length() == 9) {
                res.insert(8, "0");
            }


            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}