package com.db117.example.leetcode.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/16
 **/

public class Solution387 {
    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar1("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        // 放入map
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 找的为1的
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        char[] chars = s.toCharArray();
        // 每一个字符出现的次数
        int[] temp = new int[26];
        for (char aChar : chars) {
            temp[aChar - 'a']++;
        }
        // 找到第一个为1的
        for (int i = 0; i < chars.length; i++) {
            if (temp[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
