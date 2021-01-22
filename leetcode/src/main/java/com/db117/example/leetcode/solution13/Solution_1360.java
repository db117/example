

//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// 👍 31 👎 0


package com.db117.example.leetcode.solution13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 1360.日期之间隔几天.number-of-days-between-two-dates
 *
 * @author db117
 * @since 2021-01-22 14:24:54
 **/

public class Solution_1360 {
    public static void main(String[] args) {
        Solution solution = new Solution_1360().new Solution();

        LocalDate date1 = LocalDate.of(1977, 1, 4);
        LocalDate date2 = LocalDate.of(2078, 11, 26);

        System.out.println(solution.daysBetweenDates(date1.toString(), date2.toString()));
        System.out.println(date1.until(date2, ChronoUnit.DAYS));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //月份天数
        private int[] m = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int daysBetweenDates(String date1, String date2) {

            return Math.abs(helper(date1) - helper(date2));
        }

        // 从1971到现在的日子
        int helper(String date) {
            String[] split = date.split("-");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            int sum = 0;

            // 所有年加一起
            for (int i = 1971; i < year; i++) {
                // 闰年
                if (leap(i)) {
                    sum++;
                }
                sum += 365;
            }

            // 月份
            for (int i = 0; i < month; i++) {
                if (i == 2 && leap(year)) {
                    // 润年二月多一天
                    sum++;
                }
                sum += m[i];
            }

            // 日
            sum += day;

            return sum;
        }

        boolean leap(int year) {
            return (year % 100 != 0 && year % 4 == 0) || (year % 400 == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}