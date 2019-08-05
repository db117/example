package com.db117.example.leetcode.solution2;

import java.util.Stack;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/28/028
 **/
public class Solution200_bfs {
    public static void main(String[] args) {
        System.out.println(new Solution200_bfs().numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        }));
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // bfs辅助栈
        Stack<int[]> stack = new Stack<>();
        int row = grid.length;
        int col = grid[0].length;
        // 标记是否访问过
        boolean[][] flag = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (!flag[i][j] && grid[i][j] == '1') {
                    // 初始位置
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {
                        int[] pop = stack.pop();
                        int left = pop[0];
                        int right = pop[1];

                        // 判断边界
                        if (left < 0 || left >= row || right < 0 || right >= col) {
                            continue;
                        }
                        // 判断是否已经搞过了
                        if (flag[left][right]) {
                            continue;
                        }
                        // 标记访问过
                        flag[left][right] = true;

                        // 是陆地
                        if (grid[left][right] == '1') {
                            // 入栈
                            stack.push(new int[]{left + 1, right});
                            stack.push(new int[]{left - 1, right});
                            stack.push(new int[]{left, right + 1});
                            stack.push(new int[]{left, right - 1});
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

}
