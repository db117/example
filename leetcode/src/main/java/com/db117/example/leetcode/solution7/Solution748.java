//给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
//
// 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。在所有完整词中，最短的单词我们称之为 最
//短补全词 。 
//
// 单词在匹配牌照中的字母时要： 
//
// 
// 忽略牌照中的数字和空格。 
// 不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。 
// 如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。 
// 
//
// 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 是 "abccdef"
//、"caaacab" 以及 "cbca" 。 
//
// 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。 
//
// 
//
// 示例 1： 
//
// 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
//输出："steps"
//说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
//"step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
//"steps" 包含 "t"、"p" 和两个 "s"。
//"stripe" 缺一个 "s"。
//"stepple" 缺一个 "s"。
//因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。 
//
// 示例 2： 
//
// 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
//输出："pest"
//说明：存在 3 个包含字母 "s" 且有着最短长度的补全词，"pest"、"stew"、和 "show" 三者长度相同，但我们返回最先出现的补全词 "pes
//t" 。
// 
//
// 示例 3： 
//
// 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy
//","education","drug","prevent","writer","old"]
//输出："husband"
// 
//
// 示例 4： 
//
// 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder"
//,"box","arrive","money","tax","thus"]
//输出："enough"
// 
//
// 示例 5： 
//
// 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","
//public","never","wonder","simple","thought","use"]
//输出："simple"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= licensePlate.length <= 7 
// licensePlate 由数字、大小写字母或空格 ' ' 组成 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 15 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 
// 👍 31 👎 0

package com.db117.example.leetcode.solution7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 748.最短补全词.shortest-completing-word
 *
 * @author db117
 * @date 2020-10-09 17:59:20
 **/
public class Solution748 {
    public static void main(String[] args) {
        //""
        //["nature","though","party","food","any","democratic","building","eat","structure","our"]
        Solution solution = new Solution748().new Solution();
        System.out.println(solution.shortestCompletingWord(
                "Ar16259"
                , new String[]{
                        "nature", "though", "party", "food", "any", "democratic", "building", "eat", "structure", "our"
                }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] base = new int[26];
            count(base, licensePlate);
            // 拍照字符串数量
            int total = 0;
            for (int i : base) {
                total += i;
            }

            // 按字符串长度分组
            int finalTotal = total;
            Map<Integer, List<String>> map = Arrays.stream(words)
                    .filter(s -> s.length() >= finalTotal)
                    .collect(Collectors.groupingBy(String::length));

            int[] temp = new int[26];
            for (int i = total; i <= 1000; i++) {
                List<String> list = map.get(i);
                if (list == null || list.isEmpty()) {
                    continue;
                }
                for (String s : list) {
                    // 统计word的字符出现次数
                    count(temp, s);
                    // 是补全词直接返回
                    if (check(base, temp)) {
                        return s;
                    }
                    // 重置数组
                    Arrays.fill(temp, 0);
                }

            }

            return "";
        }

        // 统计字符出现的次数
        private void count(int[] ints, String s) {
            for (char c : s.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    ints[c - 'A']++;
                }
                if (c >= 'a' && c <= +'z') {
                    ints[c - 'a']++;
                }
            }
        }

        /**
         * 判断是否符合
         */
        private boolean check(int[] base, int[] word) {
            for (int i = 0; i < word.length; i++) {
                if (word[i] < base[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}