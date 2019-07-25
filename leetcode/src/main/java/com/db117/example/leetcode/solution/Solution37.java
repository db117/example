package com.db117.example.leetcode.solution;

import java.util.Arrays;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/18
 **/

public class Solution37 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution37().solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
//        new Solution36().isValidSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        // 一维保存位置 二维保存数值
        // 记录行是否有值
        boolean[][] rows = new boolean[9][9];
        // 记录列是否有值
        boolean[][] lists = new boolean[9][9];
        // 记录块是否有值
        boolean[][] blocks = new boolean[9][9];

        // 把原始数据标记好
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    // 不为.标记为true
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    lists[j][num] = true;
                    blocks[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }

        dfs(board, rows, lists, blocks, 0, 0);
    }

    /**
     * 回溯
     *
     * @param board  数独
     * @param rows   行标记
     * @param lists  列标记
     * @param blocks 块标记
     * @param i      行
     * @param j      列
     * @return 是否有效
     */
    public boolean dfs(char[][] board, boolean[][] rows, boolean[][] lists, boolean[][] blocks, int i, int j) {


        // 过滤有值位置
        while (board[i][j] != '.') {
            // s型
            if (j == 8) {
                if (i == 8) {
                    // 填完了
                    return true;
                }
                i++;
                j = 0;
            } else {
                j++;
            }
        }

        // 9个数
        for (int k = 0; k < 9; k++) {
            int block = i / 3 * 3 + j / 3;
            // 三个标记不存在
            if (!rows[i][k] && !lists[j][k] && !blocks[block][k]) {
                // 加标记,并设置值
                board[i][j] = (char) ('1' + k);
                rows[i][k] = true;
                lists[j][k] = true;
                blocks[block][k] = true;
                // 递归调用
                if (dfs(board, rows, lists, blocks, i, j)) {
                    return true;
                } else {
                    // 回溯
                    rows[i][k] = false;
                    lists[j][k] = false;
                    blocks[block][k] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
