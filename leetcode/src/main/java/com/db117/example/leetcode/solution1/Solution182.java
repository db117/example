package com.db117.example.leetcode.solution1;

/**
 * 182. 查找重复的电子邮箱
 * 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
 * <p>
 * 示例：
 * <p>
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * 根据以上输入，你的查询应返回以下结果：
 * <p>
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 * 说明：所有电子邮箱都是小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-emails
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/16/016 17:33
 */
public class Solution182 {
    /**
     * select distinct Email from Person group by Email having count(Email)>1
     */
}
