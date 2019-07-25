package com.db117.example.leetcode.solution;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/

public class Solution79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution79().exist(board, word));
    }

    // 上下左右
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;
    // 是否访问标记
    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        // 初始化
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                // 如果等于目标字符串的第一个字符
                if (board[x][y] == word.charAt(0)) {
                    // 递归查找
                    if (backtrack(x, y, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 回溯
     *
     * @param x     横坐标
     * @param y     纵坐标
     * @param index 已经走了几部
     * @return 是否匹配
     */
    public boolean backtrack(int x, int y, int index) {
        if (index == word.length() - 1) {
            // end
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            // 标记
            marked[x][y] = true;

            // 四个方向搞起来
            for (int i = 0; i < 4; i++) {
                // 新下标
                int newx = x + direction[i][0];
                int newy = y + direction[i][1];

                // 是否越界
                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    // 没有被使用
                    if (!marked[newx][newy]) {
                        if (backtrack(newx, newy, index + 1)) {
                            return true;
                        }
                    }
                }
            }
            // 回溯
            marked[x][y] = false;
        }

        return false;
    }
}
