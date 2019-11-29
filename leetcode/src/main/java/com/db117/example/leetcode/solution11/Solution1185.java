package com.db117.example.leetcode.solution11;

/**
 * 1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * <p>
 * 提示：
 * <p>
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/29/029 17:16
 */
public class Solution1185 {
    public static void main(String[] args) {
        System.out.println(new Solution1185().dayOfTheWeek(1, 11, 2019));
    }

    private String[] res = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        // 基姆拉尔森计算公式
        // i. 该公式中要把1月和2月分别当成上一年的13月和14月处理。
        // 例如：2008年1月4日要换成 2007年13月4日带入公式。
        // ii.该式对应的与蔡勒公式有点区别：“0”为星期1，……，“6”为星期日。

        return res[(day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7];
    }
}
