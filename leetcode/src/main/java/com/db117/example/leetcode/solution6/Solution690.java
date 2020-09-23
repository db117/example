//给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
//
// 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
// 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是
//[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，
// 但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
// 
//
// 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。 
//
// 示例 1: 
//
// 
//输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//输出: 11
//解释:
//员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
// 
//
// 注意: 
//
// 
// 一个员工最多有一个直系领导，但是可以有多个直系下属 
// 员工数量不超过2000。 
// 
// Related Topics 深度优先搜索 广度优先搜索 哈希表 
// 👍 108 👎 0


package com.db117.example.leetcode.solution6;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 690.员工的重要性
 *
 * @author db117
 * @date 2020-09-23 13:51:03
 **/
public class Solution690 {
    public static void main(String[] args) {
        Solution solution = new Solution690().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            // hash保存
            Map<Integer, Employee> map = employees.stream()
                    .collect(Collectors.toMap(e -> e.id, e -> e));
            int sum = 0;
            // 广度优先
            Queue<Employee> queue = new LinkedList<>();
            queue.add(map.get(id));
            while (!queue.isEmpty()) {
                Employee employee = queue.poll();
                sum += employee.importance;
                // 添加下属
                if (employee.subordinates != null) {
                    for (Integer i : employee.subordinates) {
                        queue.add(map.get(i));
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;
}