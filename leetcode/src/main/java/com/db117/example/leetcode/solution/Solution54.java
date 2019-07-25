package com.db117.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/26
 **/

public class Solution54 {
    public static void main(String[] args) {
        System.out.println(new Solution54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        // 定义上下左右边界
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                // 向右
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                // 如果上边界等于下边界,则结束
                break;
            }
            for (int i = up; i <= down; i++) {
                // 向下
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                // 如果右边界等于左边界
                break;
            }
            for (int i = right; i >= left; i--) {
                //  向左
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                // 如果下边界等于上边界
                break;
            }
            for (int i = down; i >= up; i--) {
                // 向上
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                // 如果右边界等于左边界
                break;
            }
        }
        return res;
    }
}
