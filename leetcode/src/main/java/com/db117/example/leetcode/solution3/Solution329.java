package com.db117.example.leetcode.solution3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/9/009 18:45
 */
public class Solution329 {
    public static void main(String[] args) {
        // [[3,4,5],[3,2,6],[2,2,1]]
        System.out.println(new Solution329.Solution().longestIncreasingPath(new int[][]{
                new int[]{3, 4, 5},
                new int[]{3, 2, 6},
                new int[]{2, 2, 1}
        }));
    }

    static class Solution {
        private int[][] matrix;
        private final int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private int[][] cache;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            this.matrix = matrix;
            this.cache = new int[matrix.length][matrix[0].length];

            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    // 遍历所有的节点,进行计算
                    max = Math.max(max, dfs(i, j));
                }
            }

            return max;
        }

        private int dfs(int row, int col) {
            if (cache[row][col] != 0) {
                // 查看是否进行过计算
                return cache[row][col];
            }
            int max = 1;
            for (int[] ints : next) {
                int x = ints[0] + row, y = ints[1] + col;
                // 没有越界,且大于当前值
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[row][col]) {
                    // 找到四个方向的最大值
                    max = Math.max(max, dfs(x, y) + 1);
                }
            }
            // 进行缓存
            cache[row][col] = max;
            return max;
        }

    }

    // 超时
    class Solution1 {
        private int[][] matrix;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            this.matrix = matrix;

            // 广度优先
            Deque<int[]> deque = new LinkedList<>();
            int row = matrix.length;
            int col = matrix[0].length;
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int count = 0;
                    deque.add(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        count++;
                        int size = deque.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = deque.poll();
                            int i1 = poll[0];
                            int i2 = poll[1];
                            int num = matrix[i1][i2];
                            // 上
                            if (check(i1, i2 + 1) && matrix[i1][i2 + 1] > num) {
                                deque.add(new int[]{i1, i2 + 1});
                            }
                            // 下
                            if (check(i1, i2 - 1) && matrix[i1][i2 - 1] > num) {
                                deque.add(new int[]{i1, i2 - 1});
                            }
                            // 左
                            if (check(i1 + 1, i2) && matrix[i1 + 1][i2] > num) {
                                deque.add(new int[]{i1 + 1, i2});
                            }
                            // 右
                            if (check(i1 - 1, i2) && matrix[i1 - 1][i2] > num) {
                                deque.add(new int[]{i1 - 1, i2});
                            }
                        }
                    }

                    // 记录最大值
                    max = Math.max(max, count);
                }
            }
            return max;
        }

        // 是否越界
        private boolean check(int row, int col) {
            if (row < 0 || row >= matrix.length) {
                return false;
            }
            return col >= 0 && col < matrix[0].length;
        }
    }
}