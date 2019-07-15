package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * <p>
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * <p>
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/9
 **/
@Slf4j
public class Solution87 {
    public static void main(String[] args) {
        System.out.println(new Solution87().isScramble("xstjzkfpkggnhjzkpfjoguxvkbuopi",
                "xbouipkvxugojfpkzjhnggkpfkzjts"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            // 只有当一样时返回true
            return true;
        }

        // 用一个数组来保存字符是否出现一样的次数
        int[] ints = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ints[s1.charAt(i) - 'a']++;
            ints[s2.charAt(i) - 'a']--;
        }
        // 如果数组不是都为0,这有不一样的字符
        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }

        // 递归
        for (int i = 1; i < s1.length(); i++) {
            // 拆分字符串,如果拆分的字符串符合标准返回true
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // 如果拆分的不符合,取s1的前i位 和s2的后i位进行比较
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
