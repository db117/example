package com.db117.example.leetcode.solution1;

/**
 * 196. 删除重复的电子邮箱
 * 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
 * <p>
 * +----+------------------+
 * | Id | Email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * | 3  | john@example.com |
 * +----+------------------+
 * Id 是这个表的主键。
 * 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
 * <p>
 * +----+------------------+
 * | Id | Email            |
 * +----+------------------+
 * | 1  | john@example.com |
 * | 2  | bob@example.com  |
 * +----+------------------+
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-duplicate-emails
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/17/017 20:23
 */
public class Solution196 {
    /**
     * mysql 不能先将select出表中的某些值，再这更新个表!
     * delete from Person where Id not in(
     *     select Id from (
     *         select min(Id) as Id from Person group by Email)t
     * );
     */
}
