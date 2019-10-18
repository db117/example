package com.db117.example.leetcode.solution1;

/**
 * 197. 上升的温度
 * 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
 * <p>
 * +---------+------------------+------------------+
 * | Id(INT) | RecordDate(DATE) | Temperature(INT) |
 * +---------+------------------+------------------+
 * |       1 |       2015-01-01 |               10 |
 * |       2 |       2015-01-02 |               25 |
 * |       3 |       2015-01-03 |               20 |
 * |       4 |       2015-01-04 |               30 |
 * +---------+------------------+------------------+
 * 例如，根据上述给定的 Weather 表格，返回如下 Id:
 * <p>
 * +----+
 * | Id |
 * +----+
 * |  2 |
 * |  4 |
 * +----+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rising-temperature
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/18/018 16:52
 */
public class Solution197 {
    /**
     * select a.Id from Weather a where a.Temperature>(
     *     select Temperature from Weather b where b.RecordDate=date_sub(a.RecordDate,interval 1 day))
     */
}
