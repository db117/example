package com.db117.example.leetcode.solution1;

/**
 * 176. 第二高的薪水
 * SQL架构
 * 表1: Person
 * <p>
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 * <p>
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 * <p>
 * <p>
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 * <p>
 * <p>
 * <p>
 * FirstName, LastName, City, State
 *
 * @author db117
 * @date 2019/10/16/016 17:00
 */
public class Solution175 {
    // select p.FirstName,p.LastName,a.City,a.State from Person p left join Address a on p.PersonId =a.PersonId;
}
