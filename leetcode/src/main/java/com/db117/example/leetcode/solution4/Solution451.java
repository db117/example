package com.db117.example.leetcode.solution4;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/16/016
 */
public class Solution451 {

    public static void main(String[] args) {
        System.out.println(new Solution451().frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        // 记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 记录出现次数的字符
        // 逆序保存出现次数
        TreeMap<Integer, List<Character>> mapIndex = new TreeMap<>((o1, o2) -> o2 - o1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            List<Character> list = mapIndex.getOrDefault(entry.getValue(), new LinkedList<>());
            list.add(entry.getKey());
            mapIndex.put(entry.getValue(), list);
        }

        // 拼接返回
        StringBuilder sb = new StringBuilder(s.length());
        mapIndex.forEach((i, c) -> {
            for (Character character : c) {
                for (int j = 0; j < i; j++) {
                    sb.append(character);
                }
            }
        });
        return sb.toString();
    }
}
