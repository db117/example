package com.db117.example.leetcode.solution;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/1
 **/

public class Solution59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution59().generateMatrix(1)));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 定义上下左右边界
        int top = 0, down = n, left = 0, right = n;

        for (int i = 1; i <= n * n; ) {
            // 向右走
            for (int j = left; j < right; j++) {
                res[top][j] = i++;
            }
            top++;

            // 向下走
            for (int j = top; j < down; j++) {
                res[j][right - 1] = i++;
            }
            right--;

            // 向左
            for (int j = right - 1; j >= left; j--) {
                res[down - 1][j] = i++;
            }
            down--;

            // 向上
            for (int j = down - 1; j >= top; j--) {
                res[j][left] = i++;
            }
            left++;
        }
        return res;
    }
}
