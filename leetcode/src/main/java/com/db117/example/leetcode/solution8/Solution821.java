//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。 
//
// 示例 1: 
//
// 
//输入: S = "loveleetcode", C = 'e'
//输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
// 
//
// 说明: 
//
// 
// 字符串 S 的长度范围为 [1, 10000]。 
// C 是一个单字符，且保证是字符串 S 里的字符。 
// S 和 C 中的所有字母均为小写字母。 
// 
// 👍 161 👎 0

package com.db117.example.leetcode.solution8;

import java.util.Arrays;

/**
 * 821.字符的最短距离.shortest-distance-to-a-character
 *
 * @author db117
 * @date 2020-10-28 18:38:18
 **/
public class Solution821 {
    public static void main(String[] args) {
        Solution solution = new Solution821().new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("eabegeghethjkhjk", 'e')));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestToChar(String S, char C) {
            int[] res = new int[S.length()];
            Arrays.fill(res, Integer.MAX_VALUE);

            char[] chars = S.toCharArray();

            int pre = -1;
            for (int i = 0; i < chars.length; i++) {
                if (pre != -1) {
                    // 记录与前面的距离
                    res[i] = i - pre;
                }
                if (chars[i] == C) {
                    // 当前位置距离为0
                    res[i] = 0;
                    pre = i;
                    // 改变前面的,从后面开始搞起来
                    for (int j = i - 1; j >= 0; j--) {
                        // 前面的数字与当前的距离
                        int n = i - j;
                        if (n < res[j]) {
                            // 距离小于之前的就直接覆盖
                            res[j] = n;
                        } else {
                            // 当距离大于之前的说明离前面的近
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}