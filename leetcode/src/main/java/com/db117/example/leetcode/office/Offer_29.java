//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 178 👎 0


package com.db117.example.leetcode.office;

import java.util.Arrays;

/**
 * 剑指 Offer 29.顺时针打印矩阵.shun-shi-zhen-da-yin-ju-zhen-lcof
 *
 * @author db117
 * @since 2021-01-13 15:57:50
 **/

public class Offer_29 {
    public static void main(String[] args) {
        Solution solution = new Offer_29().new Solution();
        // [1,2,3,4],[5,6,7,8],[9,10,11,12]
        System.out.println(Arrays.toString(solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int m = matrix.length, n = matrix[0].length;
            // 未读取的上下左右的边界
            int left = 0, right = n - 1, top = 0, down = m - 1;

            int[] ans = new int[m * n];
            int index = 0;


            while (true) {
                if (left > right) {
                    break;
                }
                // 向右
                for (int i = left; i <= right; i++) {
                    ans[index++] = matrix[top][i];
                }
                top++;

                if (top > down) {
                    break;
                }
                // 向下
                for (int i = top; i <= down; i++) {
                    ans[index++] = matrix[i][right];
                }
                right--;

                if (right < left) {
                    break;
                }
                // 向左
                for (int i = right; i >= left; i--) {
                    ans[index++] = matrix[down][i];
                }
                down--;

                if (down < top) {
                    break;
                }
                // 向上
                for (int i = down; i >= top; i--) {
                    ans[index++] = matrix[i][left];
                }
                left++;
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}