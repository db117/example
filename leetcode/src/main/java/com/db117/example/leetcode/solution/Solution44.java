package com.db117.example.leetcode.solution;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/20
 **/

public class Solution44 {
    public static void main(String[] args) {
        System.out.println(new Solution44().isMatch("aa", "a"));
    }

    public boolean isMatch(String s, String p) {
        if (p.equals(s)) {
            return true;
        }

        int sLen = s.length();
        int pLen = p.length();
        int i = 0;
        int j = 0;
        // s的最后一个匹配的位置
        int sLast = 0;
        // p的最后一个匹配位置
        int pLast = -1;

        while (i < sLen) {
            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                // 匹配
                i++;
                j++;
                continue;
            }
            // 如果碰见*,记录位置
            if (j < pLen && p.charAt(j) == '*') {
                sLast = i;
                pLast = j;
                j++;
                continue;
            }
            // 如果p中有*,p回到记录的下一个位置,s的匹配位置+1
            if (pLast != -1) {
                j = pLast + 1;
                sLast++;
                i = sLast;
                continue;
            }
            return false;
        }


        // 如果p后面有不上*的字符,直接返回false
        while (j < pLen) {
            if (p.charAt(j) != '*') {
                return false;
            }
            j++;
        }
        return true;
    }
}
