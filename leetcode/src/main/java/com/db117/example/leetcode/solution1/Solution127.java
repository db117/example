package com.db117.example.leetcode.solution1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/10/010 17:02
 */
public class Solution127 {
    public static void main(String[] args) {
        System.out.println(new Solution127().ladderLength(
                "hit"
                , "cog"
                , Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    // 慢的令人发指
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 标记是否访问过
        boolean[] flag = new boolean[wordList.size()];
        // 队列
        Deque<String> deque = new LinkedList<>();
        deque.add(beginWord);

        int res = 1;
        while (!deque.isEmpty()) {
            // 每一层加一
            res++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String poll = deque.poll();
                for (int j = 0; j < flag.length; j++) {
                    String word = wordList.get(j);
                    // 没有被访问过,而且能接上
                    if (!flag[j] && canChange(poll, word)) {
                        if (word.equals(endWord)) {
                            return res;
                        }
                        flag[j] = true;
                        deque.add(word);
                    }
                }
            }
        }

        return 0;
    }

    /**
     * 是否可以接上
     */
    private boolean canChange(String form, String to) {
        int count = 0;
        for (int i = 0; i < form.toCharArray().length; i++) {
            if (form.charAt(i) != to.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
