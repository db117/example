//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，
// 该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 104 👎 0

package com.db117.example.leetcode.solution7;

import java.util.*;

/**
 * 720.词典中最长的单词.longest-word-in-dictionary
 *
 * @author db117
 * @date 2020-09-30 18:46:45
 **/
public class Solution720 {
    public static void main(String[] args) {
        Solution solution = new Solution720().new Solution();
        String[] words = new String[]{
                "vsw","vs","zwu","vsx","nc","o","vswus","orv","imf","i","v","zw","vs"
        };
        System.out.println(solution.longestWord(words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestWord(String[] words) {
            // 排序,为了找到最小字典序
            Arrays.sort(words);
            // 方便查找
            TreeSet<String> set = new TreeSet<>();
            // 找到同样长度的字符
            Map<Integer, List<String>> map = new HashMap<>();
            // 最大的长度
            int maxLen = 0;
            for (String word : words) {
                set.add(word);
                List<String> list = map.getOrDefault(word.length(), new ArrayList<>());
                list.add(word);
                map.put(word.length(), list);

                maxLen = Math.max(maxLen, word.length());
            }

            // 总最大长度开始,按字典序开始遍历
            for (int len = maxLen; len > 0; len--) {
                List<String> strings = map.get(len);
                if (strings == null) {
                    // 没有这个长度的跳过
                   continue;
                }
                for (String word : strings) {
                    if (check(word, set)) {
                        // 如果找到了,直接返回
                        return word;
                    }
                }
            }

            return "";
        }

        // 一直往下找
        private boolean check(String word, Set<String> set) {
            if (set.contains(word)) {
                if (word.length() == 1) {
                    return true;
                }
                return check(word.substring(0, word.length() - 1), set);
            }

            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}