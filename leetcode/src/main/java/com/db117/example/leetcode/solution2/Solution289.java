package com.db117.example.leetcode.solution2;

import java.util.Arrays;

/**
 * 289. 生命游戏
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * 进阶:
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/20/020 16:44
 */
public class Solution289 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        new Solution289().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean[][] flag;
    private int[][] board;
    private int[][] map = new int[][]{
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        this.flag = new boolean[row][col];
        this.board = board;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 标记
                flag[i][j] = live(i, j);
            }
        }

        // 修改细胞状态
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = flag[i][j] ? 1 : 0;
            }
        }
    }

    /**
     * 返回是否会死亡
     * true->活
     */
    public boolean live(int i, int j) {
        int liveSum = liveNum(i, j);
        if (board[i][j] == 1) {
            // 现在活着,只有当附近有2个或者3个是才能活
            return liveSum == 2 || liveSum == 3;
        } else {
            // 现在死了,只有附近有3个活着是才能活
            return liveSum == 3;
        }
    }

    /**
     * 附近活着的细胞
     */
    public int liveNum(int i, int j) {
        int sum = 0;
        for (int[] ints : map) {
            int x = i + ints[0];
            int y = j + ints[1];
            if (check(x, y) && board[x][y] == 1) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 是否可以访问
     */
    private boolean check(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
