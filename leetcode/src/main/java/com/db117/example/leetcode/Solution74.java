package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/5
 **/
@Slf4j
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 二维转一维,二分
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col * row - 1;

        // 二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / col;
            int c = mid % col;
            int i = matrix[r][c];
            if (target == i) {
                return true;
            } else if (target < i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
