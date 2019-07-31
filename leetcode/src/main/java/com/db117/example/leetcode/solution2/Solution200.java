package com.db117.example.leetcode.solution2;

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
public class Solution200 {
    public static void main(String[] args) {
        System.out.println(new Solution200().numIslands(new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'},
        }));
    }

    private char[][] grid;
    // 是否访问过
    private boolean[][] flag;
    // 最大行
    private int row;
    // 最大列
    private int col;
    // 陆地数量
    private int count;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        this.flag = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    //没有搞过而且是陆地
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int left, int right) {
        // 判断边界
        if (left < 0 || left >= row || right < 0 || right >= col) {
            return;
        }

        // 判断是否已经搞过了
        if (flag[left][right]) {
            return;
        }
        // 标记访问过
        flag[left][right] = true;

        if (grid[left][right] == '1') {
            // 当前是陆地
            // 4个方向搞起来
            dfs(left + 1, right);
            dfs(left - 1, right);
            dfs(left, right - 1);
            dfs(left, right + 1);
        }
    }
}
