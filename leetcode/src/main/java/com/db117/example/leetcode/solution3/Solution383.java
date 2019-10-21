package com.db117.example.leetcode.solution3;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/21/021 18:27
 */
public class Solution383 {
    public static void main(String[] args) {
        System.out.println(new Solution383().canConstruct("ab", "abb"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 统计两个字符串,字符出现的次数
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            nums1[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            nums2[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // 当赎金出现的次数大于杂志的情况下,就不符合
            if (nums1[i] > nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
