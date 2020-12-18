//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。 
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// Related Topics 数组 
// 👍 31 👎 0


package com.db117.example.leetcode.solution13;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380.矩阵中的幸运数.lucky-numbers-in-a-matrix
 *
 * @author db117
 * @since 2020-12-18 17:23:48
 **/

public class Solution1380 {
    public static void main(String[] args) {
        Solution solution = new Solution1380().new Solution();
        System.out.println(solution.luckyNumbers(new int[][]{
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12},
        }));
        // [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            int[] maxs = new int[n];
            int[] mins = new int[m];

            // 找列最大值
            for (int i = 0; i < n; i++) {
                int max = Integer.MIN_VALUE;
                for (int[] ints : matrix) {
                    max = Math.max(max, ints[i]);
                }
                maxs[i] = max;
            }

            // 行最小值
            for (int i = 0; i < m; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    min = Math.min(min, matrix[i][j]);
                }
                mins[i] = min;
            }

            List<Integer> res = new ArrayList<>();
            // 一个个比
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int num = matrix[i][j];
                    // 是行最小值,且是列最大值
                    if (num == maxs[j] && num == mins[i]) {
                        res.add(num);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}