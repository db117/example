package com.db117.example.leetcode.solution2;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/19/019
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int colLen = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            // 目标值大于等于最左边,小于等于最右边
            if (matrix[i][0] <= target && matrix[i][colLen - 1] >= target) {
                if (rowBs(i, matrix, target)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean rowBs(int row, int[][] matrix, int target) {
        // 一行一行二分
        int left = 0, right = matrix[0].length;
        while (left < right) {
            int mid = (left + right) / 2;
            int temp = matrix[row][mid];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
