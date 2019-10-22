package com.db117.example.leetcode.solution3;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/22/022 10:24
 */
public class Solution389 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        // 自己与自己异或则为0
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            c = (char) (c ^ s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            c = (char) (c ^ t.charAt(i));
        }

        return c;
    }

    public char findTheDifference1(String s, String t) {
        int[] ints = new int[26];

        // 记录每个字符出现的次数,不为0的则为多的那个字符
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }
        ints[t.charAt(t.length() - 1) - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) {
                return (char) (i + 'a');
            }
        }

        // 不会执行
        return 'a';
    }
}
