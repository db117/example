package com.db117.example.leetcode.solution5;

import java.util.Arrays;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/7/007
 **/
public class Solution542 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution542().updateMatrix(new int[][]{
                new int[]{0, 1, 1},
                new int[]{1, 1, 0},
                new int[]{1, 1, 1}
        })));
    }

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 左上角开始分析
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 跳过0
                if (matrix[i][j] == 0) {
                    continue;
                }

                int min = 10001;
                // 上边
                if (i > 0) {
                    min = matrix[i - 1][j];
                }
                // 左边
                if (j > 0) {
                    min = Math.min(min, matrix[i][j - 1]);
                }
                matrix[i][j] = min + 1;
            }
        }

        // 右下角开始分析
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 跳过0
                if (matrix[i][j] == 0) {
                    continue;
                }

                int min = 10001;
                // 左边
                if (i < row - 1) {
                    min = matrix[i + 1][j];
                }
                // 右边
                if (j < col - 1) {
                    min = Math.min(min, matrix[i][j + 1]);
                }
                // 跟从左上角开始的取最小的
                matrix[i][j] = Math.min(min + 1, matrix[i][j]);
            }
        }
        return matrix;
    }

}
