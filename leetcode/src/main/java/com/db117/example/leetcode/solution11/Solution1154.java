//给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字。 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。 
// 
// Related Topics 数学 
// 👍 33 👎 0


package com.db117.example.leetcode.solution11;

/**
 * 1154.一年中的第几天.day-of-the-year
 *
 * @author db117
 * @since 2020-12-14 18:20:33
 **/

public class Solution1154 {
    public static void main(String[] args) {
        Solution solution = new Solution1154().new Solution();
        System.out.println(solution.dayOfYear("2000-03-25"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dayOfYear(String date) {
            int[] temp = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int ans = 0;

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            // 闰年二月29天
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                temp[1] = 29;
            }

            // 当前之前的月分全部加上
            for (int i = 0; i < month - 1; i++) {
                ans += temp[i];
            }
            // 加上当前月已经过去的日子
            return ans + day;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}