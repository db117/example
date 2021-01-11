


// 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 41 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 01.04.回文排列.palindrome-permutation-lcci
 *
 * @author db117
 * @since 2021-01-11 11:21:27
 **/

public class Interview_0104 {
    public static void main(String[] args) {
        Solution solution = new Interview_0104().new Solution();
        System.out.println(solution.canPermutePalindrome("AaBb//a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            // 记录每一个字符出现的次数
            int[] tmp = new int[128];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                tmp[c]++;
            }

            // 奇数个数最多只能出现一次
            int odd = 0;
            for (int j : tmp) {
                if (j % 2 == 1) {
                    odd++;
                }
                if (odd > 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}