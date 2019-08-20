package com.db117.example.leetcode.solution1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/20/020
 */
public class Solution139 {
    public static void main(String[] args) {
        //"cars"
        //["car","ca","rs"]
        System.out.println(new Solution139().wordBreak("cars",
                Arrays.asList(
                        "car", "ca", "rs"
                )));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划
        // 表示下标前的字符串是否符合题意
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);

        // 遍历每一个字符
        for (int i = 1; i <= s.length(); i++) {
            // 才分成0-j j-i 两个字符串
            for (int j = 0; j < i; j++) {
                // 如果0-j 符合 且第二个字符也符合
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 超时
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String s1 : wordDict) {
            if (s.startsWith(s1)) {
                // 截取当前匹配的字符串继续处理
                if (wordBreak(s.substring(s1.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
