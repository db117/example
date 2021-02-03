//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 658 👎 0


package com.db117.example.leetcode.solution2;

/**
 * 221.最大正方形.maximal-square
 *
 * @author db117
 * @since 2021-02-03 14:10:04
 **/

public class Solution_221 {
    public static void main(String[] args) {
        Solution solution = new Solution_221().new Solution();
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '0'},
        }));
        System.out.println(solution.maximalSquare(new char[][]{
                {'1'}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;


            int max = 0;
            // 如果上左边界有一个为1则max的最小值为1
            for (char[] chars : matrix) {
                if (chars[0] == '1') {
                    max = 1;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (max == 1) {
                    break;
                }
                if (matrix[0][i] == '1') {
                    max = 1;
                    break;
                }
            }

            // 以当前节点为正方形右下角时最大的边长
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        continue;
                    }
                    // 上,左,左上 三个点为正方形右下角时的最大边长
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, matrix[i - 1][j] - '0');
                    min = Math.min(min, matrix[i][j - 1] - '0');
                    min = Math.min(min, matrix[i - 1][j - 1] - '0');

                    // 当前节点的最大边长为其他三个节点的最小值+1
                    matrix[i][j] = (char) ((min + 1) + '0');
                    max = Math.max(max, matrix[i][j] - '0');
                }
            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}