package com.db117.example.leetcode.solution4;

import java.util.Arrays;

/**
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/25/025
 **/
public class Solution498 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        System.out.println(Arrays.toString(new Solution498().findDiagonalOrder(matrix)));
    }

    /**
     * ......1
     * ...4     2
     * 7     5     3
     * ...8     6
     * ......9
     * <p>索引位置
     * .......0,0
     * ...1,0      0,1
     * 2,0    1,1    0,2
     * ...2,1      1,2
     * .......2,2
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        if (col == 0) {
            return new int[0];
        }
        int len = Math.max(row, col);
        // 不是正方形,补成正方形

        int[] res = new int[row * col];
        int index = 0;
        for (int i = 0; i < row + col; i++) {
            // 每一层数字数量
            int num = i <= len - 1 ? i + 1 : len * 2 - i - 1;

            // 当前层最大的索引值
            int max = Math.min(len - 1, i);

            // 方向
            // 奇数层从右往左(从0开始)
            boolean flag = i % 2 == 0;

            for (int j = 0; j < num; j++) {
                if (flag) {
                    // 从左往右
                    // 判断是否有效
                    if (max < row && (i - max) < col) {
                        res[index++] = matrix[max][i - max];
                    }
                } else {
                    // 从右往左
                    if (max < col && (i - max) < row) {
                        res[index++] = matrix[i - max][max];
                    }
                }
                max--;
            }
        }
        return res;
    }
}
