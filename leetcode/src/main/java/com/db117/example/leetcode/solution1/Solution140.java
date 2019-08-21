package com.db117.example.leetcode.solution1;

import java.util.*;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/20/020
 */
public class Solution140 {
    public static void main(String[] args) {
        System.out.println(new Solution140().wordBreak("catsanddog", Arrays.asList(
                "cat", "cats", "and", "sand", "dog"
        )));
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        if (check(s, set)) {
            dfs(s, set, 0, new StringBuilder(), res);
        }
        return res;
    }

    /**
     * 深度优先
     *
     * @param s             字符串
     * @param wordDict      字典
     * @param index         索引
     * @param stringBuilder 字符串缓存
     * @param res           返回集合
     */
    public void dfs(String s, Set<String> wordDict, int index, StringBuilder stringBuilder, List<String> res) {
        if (index == s.length()) {
            // 找到并添加
            res.add(stringBuilder.toString().trim());
        }

        String s1;
        for (int i = index; i < s.length(); i++) {
            s1 = s.substring(index, i + 1);
            // 包含则添加
            if (wordDict.contains(s1)) {
                stringBuilder.append(s1).append(" ");
                // 递归调用
                dfs(s, wordDict, i + 1, stringBuilder, res);
                // 回溯
                stringBuilder.delete(stringBuilder.length() - s1.length() - 1, stringBuilder.length());
            }
        }
    }

    /**
     * 根据139题改的,判断是否可以拆分
     */
    public boolean check(String s, Set<String> set) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
