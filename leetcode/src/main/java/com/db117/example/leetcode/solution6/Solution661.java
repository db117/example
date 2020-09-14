//包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
// 平均灰度的计算是周围的8个单元和它本身的值
//求平均，如果周围的单元格不足八个，则尽可能多的利用它们。 
//
// 示例 1: 
//
// 
//输入:
//[[1,1,1],
// [1,0,1],
// [1,1,1]]
//输出:
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
// 
//
// 注意: 
//
// 
// 给定矩阵中的整数范围为 [0, 255]。 
// 矩阵的长和宽的范围均为 [1, 150]。 
// 
// Related Topics 数组 
// 👍 62 👎 0


package com.db117.example.leetcode.solution6;

import java.util.Arrays;

/**
 * 661.图片平滑器
 *
 * @author db117
 * @date 2020-09-11 16:01:18
 **/
public class Solution661 {
    public static void main(String[] args) {
        Solution solution = new Solution661().new Solution();
        System.out.println(Arrays.deepToString(solution.imageSmoother(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 3, 1},
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方向
        private int[][] diff = new int[][]{
                {-1, 0}, {-1, 1}, {-1, -1},
                {1, 1}, {1, 0}, {1, -1},
                {0, 1}, {0, -1}, {0, 0}
        };

        public int[][] imageSmoother(int[][] M) {
            int[][] res = new int[M.length][M[0].length];
            for (int y = 0; y < M.length; y++) {
                for (int x = 0; x < M[y].length; x++) {
                    res[y][x] = helper(M, x, y);
                }
            }
            return res;
        }

        private int helper(int[][] M, int x, int y) {
            int sum = 0, n = 0;
            for (int[] ints : diff) {
                int tx = ints[0] + x;
                int ty = ints[1] + y;
                // 九个位置判断是否可以访问
                if (tx >= 0
                        && ty >= 0
                        && tx < M[0].length
                        && ty < M.length) {
                    sum += M[ty][tx];
                    n++;
                }
            }
            return sum / n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}