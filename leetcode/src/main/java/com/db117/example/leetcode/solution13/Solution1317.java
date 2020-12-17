//「无零整数」是十进制表示中 不含任何 0 的正整数。 
//
// 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足： 
//
// 
// A 和 B 都是无零整数 
// A + B = n 
// 
//
// 题目数据保证至少有一个有效的解决方案。 
//
// 如果存在多个有效解决方案，你可以返回其中任意一个。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：[1,1]
//解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：[2,9]
// 
//
// 示例 3： 
//
// 输入：n = 10000
//输出：[1,9999]
// 
//
// 示例 4： 
//
// 输入：n = 69
//输出：[1,68]
// 
//
// 示例 5： 
//
// 输入：n = 1010
//输出：[11,999]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^4 
// 
// Related Topics 数学 
// 👍 18 👎 0


package com.db117.example.leetcode.solution13;

import java.util.Arrays;

/**
 * 1317.将整数转换为两个无零整数的和.convert-integer-to-the-sum-of-two-no-zero-integers
 *
 * @author db117
 * @since 2020-12-16 17:02:46
 **/

public class Solution1317 {
    public static void main(String[] args) {
        Solution solution = new Solution1317().new Solution();

        for (int i = 2; i < 10000; i++) {
            System.out.println(Arrays.toString(solution.getNoZeroIntegers(i)));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getNoZeroIntegers(int n) {
            for (int i = 1; i < n; i++) {
                if (check(i) && check(n - i)) {
                    return new int[]{i, n - i};
                }
            }

            return new int[0];
        }

        private boolean check(int n) {
            return !String.valueOf(n).contains("0");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}