package com.db117.example.leetcode.solution3;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢:
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/22/022 10:41
 */
public class Solution392 {
    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            if (t.charAt(index2) == s.charAt(index1)) {
                // 相等则都增加
                index1++;
            }
            index2++;
        }

        return s.length() == index1;
    }
}
