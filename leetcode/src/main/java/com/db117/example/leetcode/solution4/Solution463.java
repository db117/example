package com.db117.example.leetcode.solution4;

/**
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/18/018 18:01
 */
public class Solution463 {


    public static void main(String[] args) {
        System.out.println(new Solution463().islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        }));
    }

    private static final int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count += count(grid, i, j);
                }
            }
        }

        return count;
    }

    private int count(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int[] ints : d) {
            int i = row + ints[0];
            int j = col + ints[1];
            if (i < 0 || i >= rows || j < 0 || j >= cols) {
                count++;
                continue;
            }

            if (grid[i][j] == 0) {
                count++;
            }
        }
        return count;
    }
}
