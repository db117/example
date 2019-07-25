package com.db117.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/24
 **/

public class Solution51 {

    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new boolean[n][n], 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return res;
    }

    /**
     * 回溯
     *
     * @param res   目标集合
     * @param temp  当前处理中数据
     * @param n     已经放了几个
     * @param row   行
     * @param left  左斜线
     * @param right 有斜线
     */
    public void backtrack(List<List<String>> res, boolean[][] temp, int n, boolean[] row, boolean[] left, boolean[] right) {
        int len = row.length;
        if (n == len) {
            // 结束
            List<String> list = new ArrayList<>();
            for (boolean[] booleans : temp) {
                StringBuilder stringBuilder = new StringBuilder();
                for (boolean aBoolean : booleans) {
                    if (aBoolean) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                list.add(stringBuilder.toString());
            }
            res.add(list);
        }

        for (int i = 0; i < len; i++) {
            if (!row[i] && !left[i + n] && !right[len - 1 + i - n]) {
                row[i] = true;
                left[i + n] = true;
                right[len - 1 + i - n] = true;
                temp[i][n] = true;

                backtrack(res, temp, n + 1, row, left, right);

                row[i] = false;
                left[i + n] = false;
                right[len - 1 + i - n] = false;
                temp[i][n] = false;
            }
        }
    }
}
