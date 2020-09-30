//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
//
// 重复出现的子串要计算它们出现的次数。 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 注意： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 字符串 
// 👍 291 👎 0

package com.db117.example.leetcode.solution6;

import java.util.ArrayList;
import java.util.List;

/**
 * 696.计数二进制子串.count-binary-substrings
 *
 * @author db117
 * @date 2020-09-29 17:32:23
 **/
public class Solution696 {
    public static void main(String[] args) {
        Solution solution = new Solution696().new Solution();
        System.out.println(solution.countBinarySubstrings("00110011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            int count = 0;
            // 统计出每一个数字出现的次数
            char[] chars = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            // 双指针
            int left = 0, right = 0;
            while (right < chars.length) {
                while (right < chars.length && chars[left] == chars[right]) {
                    right++;
                }
                list.add(right - left);
                left = right;
            }

            for (int i = 1; i < list.size(); i++) {
                // 两个相邻的数字最小的就是这两个数字能组成的个数
                count += Math.min(list.get(i), list.get(i - 1));
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // 超时了
    class Solution1 {
        public int countBinarySubstrings(String s) {
            if (s == null || s.length() == 1) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int /*1的个数*/ len_1 = 0, /*0的个数*/ len_0 = 0;
            int res = 0;
            // 是否已经有不一样的数字
            boolean flag = false;
            for (int left = 0; left < chars.length; left++) {
                // 重置数据
                len_0 = 0;
                len_1 = 0;
                flag = false;

                for (int right = left; right < chars.length; right++) {
                    if (chars[right] == '1') {
                        len_1++;
                    } else {
                        len_0++;
                    }


                    if (right > left && chars[right] != chars[right - 1]) {
                        // 有不连续的数字,只能出现一次
                        if (flag) {
                            break;
                        }
                        flag = true;
                    }


                    if (len_0 == len_1) {
                        // 找到数量相同,连续的字符串
                        res++;
                    }
                }

            }
            return res;
        }

    }
}