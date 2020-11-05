//给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。 
//
// 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。 
//
// 山羊拉丁文的规则如下： 
//
// 
// 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 
// 例如，单词"apple"变为"applema"。 
// 
// 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 
// 例如，单词"goat"变为"oatgma"。 
// 
// 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 
// 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。 
// 
//
// 返回将 S 转换为山羊拉丁文后的句子。 
//
// 示例 1: 
//
// 
//输入: "I speak Goat Latin"
//输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// 
//
// 示例 2: 
//
// 
//输入: "The quick brown fox jumped over the lazy dog"
//输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaa
//aaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
// 
//
// 说明: 
//
// 
// S 中仅包含大小写字母和空格。单词间有且仅有一个空格。 
// 1 <= S.length <= 150。 
// 
// Related Topics 字符串 
// 👍 46 👎 0


package com.db117.example.leetcode.solution8;

/**
 * 824.山羊拉丁文.goat-latin
 *
 * @author db117
 * @since 2020-11-04 18:02:52
 **/

public class Solution824 {
    public static void main(String[] args) {
        Solution solution = new Solution824().new Solution();
        String res = solution.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(res);
        System.out.println(res.equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toGoatLatin(String S) {
            // a, e, i, o, u
            StringBuilder s = new StringBuilder(S);

            // 单词顺序
            int n = 1;
            // 当前单词的开始位置
            int start = 0;
            // 字符串当前位置
            int i = 0;
            while (i < s.length()) {

                // 找到空格
                if (s.charAt(i) == ' ') {
                    char c = s.charAt(start);

                    if (!helper(c)) {
                        // 非元音
                        // 移动首字母
                        s.deleteCharAt(start);
                        s.insert(i - 1, c);
                    }
                    s.insert(i, "ma");
                    i += 2;


                    for (int j = 0; j < n; j++) {
                        s.insert(i++, 'a');
                    }

                    start = -1;
                    n++;
                } else {
                    if (start == -1) {
                        start = i;
                    }
                }
                i++;
            }

            // 最后一个单词
            char c = s.charAt(start);
            // 找到空格

            // 元音
            if (!helper(c)) {
                // 非元音
                // 移动首字母
                s.deleteCharAt(start);
                s.insert(i - 1, c);
            }

            s.append("ma");
            for (int j = 0; j < n; j++) {
                s.append('a');
            }


            return s.toString();
        }

        boolean helper(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return true;
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}