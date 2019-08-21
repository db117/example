package com.db117.example.leetcode.solution2;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/21/021
 */
public class Solution208 {
    class Trie {
        // 子节点
        Trie[] child = new Trie[26];
        // 是否是最后一个
        boolean isEnd;


        // 获取子节点
        public Trie get(char c1) {
            return child[c1 - 'a'];
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.toCharArray().length; i++) {
                // 生成子节点
                if (trie.child[word.charAt(i) - 'a'] == null) {
                    trie.child[word.charAt(i) - 'a'] = new Trie();
                }
                // 把当前节点设为非子节点
                trie = trie.get(word.charAt(i));
            }
            trie.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.toCharArray().length; i++) {
                // 获取下一级
                trie = trie.get(word.charAt(i));
                if (trie == null) {
                    // 没有找到说明不存在
                    return false;
                }
            }
            // 判断下一级是否为空
            return trie.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.toCharArray().length; i++) {
                // 获取下一级
                trie = trie.get(prefix.charAt(i));
                if (trie == null) {
                    // 没有找到说明不存在
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
