//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 
// 👍 140 👎 0


package com.db117.example.leetcode.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187.重复的DNA序列.repeated-dna-sequences
 *
 * @author db117
 * @since 2021-01-29 16:31:09
 **/

public class Solution_187 {
    public static void main(String[] args) {
        Solution solution = new Solution_187().new Solution();

        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> findRepeatedDnaSequences(String s) {
            if (s == null || s.length() < 10) {
                return new ArrayList<>();
            }
            List<String> ans = new ArrayList<>();

            // 记录每一位数字出现的次数
            Map<Long, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();

            // 把十位字符串标准化为数字
            // 记录当前的数字
            long n = 0L;
            for (int i = 0; i < 10; i++) {
                n *= 10;
                n += toLong(chars[i]);
            }

            map.put(n, 1);

            for (int i = 1; i <= chars.length - 10; i++) {
                // 向前走删除第一个数字,加上后面一个数字
                long del = toLong(chars[i - 1]);
                long add = toLong(chars[i + 9]);

                n -= (del * 1000000000L);
                n *= 10;
                n += add;

                Integer count = map.getOrDefault(n, 0);
                if (count == 1) {
                    ans.add(toString(chars, i));
                }
                map.put(n, count + 1);
            }
            return ans;
        }

        String toString(char[] chars, int start) {
            char[] ans = new char[10];
            System.arraycopy(chars, start, ans, 0, 10);
            return new String(ans);
        }

        long toLong(char c) {
            switch (c) {
                case 'A':
                    return 1;
                case 'C':
                    return 2;
                case 'G':
                    return 3;
                case 'T':
                    return 4;
                default:
                    return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}