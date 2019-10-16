package com.db117.example.leetcode.solution1;

/**
 * 176. 第二高的薪水
 * SQL架构
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 * <p>
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
 * <p>
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 *
 * @author db117
 * @date 2019/10/16/016 17:06
 */
public class Solution176 {
    // 空转换,去重
    // select ifnull((select distinct Salary from Employee order by Salary desc limit 1,1),null)as SecondHighestSalary;
}
