package com.db117.example.leetcode.solution;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/1
 **/

public class Solution58 {
    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String trim = s.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        // 找最后一个空格
        int index = trim.lastIndexOf(" ");
        if (index == -1) {
            return trim.length();
        }
        return trim.length() - index - 1;
    }
}
