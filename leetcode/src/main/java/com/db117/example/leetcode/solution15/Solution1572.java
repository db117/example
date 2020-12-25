//给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。 
//
// 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//输出：25
//解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
//请注意，元素 mat[1][1] = 5 只会被计算一次。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1]]
//输出：8
// 
//
// 示例 3： 
//
// 
//输入：mat = [[5]]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// n == mat.length == mat[i].length 
// 1 <= n <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 16 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1572.矩阵对角线元素的和.matrix-diagonal-sum
 *
 * @author db117
 * @since 2020-12-25 15:37:14
 **/

public class Solution1572 {
    public static void main(String[] args) {
        Solution solution = new Solution1572().new Solution();
        System.out.println(solution.diagonalSum(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},

        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int diagonalSum(int[][] mat) {
            int len = mat.length;
            int ans = 0;

            for (int i = 0; i < len; i++) {
                // 斜上
                ans += mat[i][i];
                if (len - 1 - i != i) {
                    // 不相交,斜下
                    ans += mat[i][len - 1 - i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}