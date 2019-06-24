package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/24
 **/
@Slf4j
public class Solution49 {
    public static void main(String[] args) {
        System.out.println(new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);

        for (String str : strs) {
            // 以排完序的字节数组做k
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (map.containsKey(s)) {
                // 如果已经存在,加入到集合中
                List<String> list = map.get(s);
                list.add(str);
            } else {
                // 如果不存在,新建集合
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(s, strings);
            }
        }
        return new ArrayList<>(map.values());
    }

}
