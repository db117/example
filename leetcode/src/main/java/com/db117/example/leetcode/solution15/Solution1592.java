//给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 
//text 至少包含一个单词 。 
//
// 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也
//意味着返回的字符串应当与原 text 字符串的长度相等。 
//
// 返回 重新排列空格后的字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：text = "  this   is  a sentence "
//输出："this   is   a   sentence"
//解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
// 
//
// 示例 2： 
//
// 输入：text = " practice   makes   perfect"
//输出："practice   makes   perfect "
//解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
// 
//
// 示例 3： 
//
// 输入：text = "hello   world"
//输出："hello   world"
// 
//
// 示例 4： 
//
// 输入：text = "  walks  udp package   into  bar a"
//输出："walks  udp  package  into  bar  a "
// 
//
// 示例 5： 
//
// 输入：text = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 100 
// text 由小写英文字母和 ' ' 组成 
// text 中至少包含一个单词 
// 
// Related Topics 字符串 
// 👍 6 👎 0


package com.db117.example.leetcode.solution15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1592.重新排列单词间的空格.rearrange-spaces-between-words
 *
 * @author db117
 * @since 2020-12-25 18:18:56
 **/

public class Solution1592 {
    public static void main(String[] args) {
        Solution solution = new Solution1592().new Solution();
        System.out.println(solution.reorderSpaces("  walks  a  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorderSpaces(String text) {
            // 空格数
            int total = 0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    total++;
                }
            }

            StringBuilder s = new StringBuilder();
            String[] split = text.split(" ");
            // 去除空格
            List<String> list = Arrays.stream(split)
                    .filter(s1 -> !s1.equals(""))
                    .collect(Collectors.toList());
            int size = list.size();
            // 每一个单词的间距
            int n = size == 1 ? 1 : total / (size - 1);
            // 最后一段空格的长度
            int t = size == 1 ? total : total % (size - 1);

            for (int k = 0; k < size; k++) {
                String st = list.get(k);
                s.append(st);
                if (k == size - 1) {
                    // 最后一个单词
                    for (int i = 0; i < t; i++) {
                        s.append(' ');
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        s.append(' ');
                    }
                }
            }


            return s.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}