package com.db117.example.leetcode.solution1;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/23/023 16:46
 */
public class Solution130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X'}

        };

        new Solution130().solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    int row, col;

    // 并查集
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;

        UnionFind find = new UnionFind(row * col + 1);
        // 边界位置
        int temp = row * col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int node = node(i, j);
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        // 合并边界
                        find.union(temp, node);
                    } else {
                        // 合并上下左右
                        if (board[i - 1][j] == 'O') {
                            find.union(node, node(i - 1, j));
                        }
                        if (board[i + 1][j] == 'O') {
                            find.union(node, node(i + 1, j));
                        }
                        if (board[i][j - 1] == 'O') {
                            find.union(node, node(i, j - 1));
                        }
                        if (board[i][j + 1] == 'O') {
                            find.union(node, node(i, j + 1));
                        }
                    }
                }
            }
        }

        // 充填
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (find.find(temp) != find.find(node(i, j))) {
                    // 不是边界
                    board[i][j] = 'X';
                }
            }

        }

    }

    int node(int i, int j) {
        return i * row + j;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int node) {
            while (node != parents[node]) {
                // 当当前的上级不是自己是,把当前的上级指向上级的上级
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            // 找到最上面的一级
            return node;
        }

        public void union(int left, int right) {
            int x = find(left);
            int y = find(right);
            if (x != y) {
                // 当这两个的上级不是同一个是,指定为同一个
                parents[x] = y;
            }
        }
    }
}
