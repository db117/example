package com.db117.example.leetcode.solution2;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/17
 **/

public class Solution242 {
    public static void main(String[] args) {
        System.out.println(new Solution242().isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null | t == null || s.length() != t.length()) {
            return false;
        }
        // 每一位字母出现的次数
        int[] temp = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            temp[s.charAt(i) - 'a']++;
        }

        // 减去每一位字母出现的次数
        // 小于0则不是字母异位词
        for (int i = 0; i < len; i++) {
            int index = t.charAt(i) - 'a';
            if (temp[index] == 0) {
                return false;
            }
            temp[index]--;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s == null | t == null || s.length() != t.length()) {
            return false;
        }
        // 每一位字母出现的次数
        int[] temp = new int[26];
        int len = s.length();
        // 一加一减
        for (int i = 0; i < len; i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        // 有不为0的不是有效的字母异位词
        for (int value : temp) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
