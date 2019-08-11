package com.db117.example.leetcode.solution5;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/11/011
 **/
public class Solution599 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution599().findRestaurant(new String[]{
                "Shogun", "Tapioca Express", "Burger King", "KFC"
        }, new String[]{
                "KFC", "Burger King", "Tapioca Express", "Shogun"
        })));
    }

    // todo 可以优化成一个map,value直接放入和
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> res = new HashSet<>();
        // 把数据放入map
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map1.put(list2[i], i);
        }

        int min = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String s = entry.getKey();
            Integer i = entry.getValue();
            if (!map.containsKey(s)) {
                // 第一个数组没有改数据
                continue;
            }
            int temp = i + map.get(s);

            // 如果相等则添加到返回集合
            if (temp == min) {
                res.add(s);
            } else if (temp < min) {
                // 如果小于则清空返回值,并把当前字符串加入
                res.clear();
                res.add(s);
                min = temp;
            }
        }

        return res.toArray(new String[0]);
    }
}
