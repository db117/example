package com.db117.example.leetcode.solution11;

import java.util.Arrays;

/**
 * 1170. 比较字符串最小字母出现频次
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/1/14/014 10:37
 */
public class Solution1170 {
    public static void main(String[] args) {
        // ["bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"]
        //["aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"]
        System.out.println(Arrays.toString(new Solution1170().numSmallerByFrequency(new String[]{
                "bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"
        }, new String[]{
                "aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"
        })));
    }


    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordNum = new int[words.length];

        // 找到字典的最小字符出现次数
        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            wordNum[i] = helper(words[i]);
        }

        Arrays.sort(wordNum);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = find(wordNum, helper(queries[i]));
            ans[i] = index == -1 ? 0 : (words.length - index);
        }
        return ans;
    }

    // 找到大于目标值的最小索引
    private int find(int[] src, int target) {
        int left = 0, right = src.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = src[mid];
            if (num < target) {
                left = mid + 1;
            } else if (num > target) {
                if (mid == 0 || src[mid - 1] <= target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    // 最小字符出现的次数
    private int helper(String s) {
        int len = s.length();
        if (len == 1) {
            return len;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        char min = chars[0];
        for (char c : chars) {
            if (c < min) {
                min = c;
                count = 0;
            }
            if (c == min) {
                count++;
            }
        }
        return count;
    }
}

