package com.db117.example.leetcode.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/20/020 16:15
 */
public class Solution290 {
    public static void main(String[] args) {
        System.out.println(new Solution290().wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] hash = new String[26];
        char[] chars = pattern.toCharArray();
        String[] split = str.split(" ");
        if (chars.length != split.length) {
            // 长度不一致
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            int index = chars[i] - 'a';
            String s = split[i];

            if (hash[index] == null) {
                // 第一次匹配上
                hash[index] = s;
            } else {
                if (!hash[index].equals(s)) {
                    // 不相等
                    return false;
                }
            }
        }

        // 校验是否重复
        Set<String> set = new HashSet<>();
        for (String s : hash) {
            if (s != null && !set.add(s)) {
                return false;
            }
        }

        return true;
    }
}
