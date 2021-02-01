// 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最调用多 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 回溯算法 
// 👍 205 👎 0


package com.db117.example.leetcode.solution2;

/**
 * 211.添加与搜索单词 - 数据结构设计.design-add-and-search-words-data-structure
 *
 * @author db117
 * @since 2021-02-01 11:27:22
 **/

public class Solution_211 {
    public static void main(String[] args) {
        WordDictionary solution = new Solution_211().new WordDictionary();
        // ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
        //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        solution.addWord("at");
        solution.addWord("and");
        solution.addWord("an");
        solution.addWord("add");
        System.out.println(solution.search("a"));
        System.out.println(solution.search(".at"));
        solution.addWord("bat");
        System.out.println(solution.search(".at"));
        System.out.println(solution.search("an."));
        System.out.println(solution.search("a.d."));
        System.out.println(solution.search("b."));
        System.out.println(solution.search("a.d"));
        System.out.println(solution.search("."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        // 根
        Dic dic;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            dic = new Dic();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Dic tmp = dic;
            // 依次添加
            for (char c : chars) {
                int i = c - 'a';
                if (tmp.child == null) {
                    tmp.child = new Dic[26];
                }
                if (tmp.child[i] == null) {
                    tmp.child[i] = new Dic();
                }

                tmp = tmp.child[i];
            }
            // 是结束节点
            tmp.end = true;
        }

        public boolean search(String word) {
            return dfs(word.toCharArray(), 0, dic);
        }

        boolean dfs(char[] chars, int index, Dic dic) {
            if (dic == null || index > chars.length) {
                return false;
            }
            // 刚好是最后一个字符
            if (chars.length == index && dic.end) {
                return true;
            }
            // 已经没有子节点了,或者没有字符了
            if (dic.child == null || index == chars.length) {
                return false;
            }

            char c = chars[index];

            if (c == '.') {
                // 遍历所有可能,找到一个就可以了
                for (Dic d : dic.child) {
                    if (dfs(chars, index + 1, d)) {
                        return true;
                    }
                }
                // 都没有找到
                return false;
            }

            // 继续找下一个字符
            return dfs(chars, index + 1, dic.child[c - 'a']);
        }

        class Dic {
            /**
             * 是否结束
             */
            boolean end;
            // 26个子节点
            Dic[] child;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}