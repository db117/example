package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/26
 **/
@Slf4j
public class Solution52 {
    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(55));
    }

    public int totalNQueens(int n) {
        return backtrack(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    /**
     * 回溯
     *
     * @param n     已经放了几个了
     * @param row   记录行是否放了
     * @param left  记录左斜线是否放了
     * @param right 记录右斜线
     * @return 右几种可能
     */
    public int backtrack(int n, boolean[] row, boolean[] left, boolean[] right) {
        int len = row.length;
        int res = 0;
        if (n == len) {
            return 1;
        }

        for (int i = 0; i < len; i++) {
            if (!row[i] && !left[i + n] && !right[len - 1 + i - n]) {
                row[i] = true;
                left[i + n] = true;
                right[len - 1 + i - n] = true;

                res += backtrack(n + 1, row, left, right);

                row[i] = false;
                left[i + n] = false;
                right[len - 1 + i - n] = false;
            }
        }

        return res;
    }
}
