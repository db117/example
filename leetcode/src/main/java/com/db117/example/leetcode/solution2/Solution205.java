package com.db117.example.leetcode.solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/11/011
 **/
public class Solution205 {
    public static void main(String[] args) {
        System.out.println(new Solution205().isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        // 第一个字符串->第二个字符串
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    // 如果s有,但不等于t
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    // s没有,t有
                    return false;
                }
                // 放入缓存
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

}
