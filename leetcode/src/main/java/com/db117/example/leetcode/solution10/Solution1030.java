//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。 
//
// 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。 
//
// 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈
//顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。） 
//
// 
//
// 示例 1： 
//
// 输入：R = 1, C = 2, r0 = 0, c0 = 0
//输出：[[0,0],[0,1]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
// 
//
// 示例 2： 
//
// 输入：R = 2, C = 2, r0 = 0, c0 = 1
//输出：[[0,1],[0,0],[1,1],[1,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
//[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
// 
//
// 示例 3： 
//
// 输入：R = 2, C = 3, r0 = 1, c0 = 2
//输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
//其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= R <= 100 
// 1 <= C <= 100 
// 0 <= r0 < R 
// 0 <= c0 < C 
//
// Related Topics 排序 
// 👍 94 👎 0


package com.db117.example.leetcode.solution10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1030.距离顺序排列矩阵单元格.matrix-cells-in-distance-order
 *
 * @author db117
 * @since 2020-12-03 11:20:22
 **/

public class Solution1030 {
    public static void main(String[] args) {
        Solution solution = new Solution1030().new Solution();
        System.out.println(Arrays.deepToString(solution.allCellsDistOrder(
                2,
                3,
                1,
                2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            // 广度优先
            // 方向
            int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // 返回的数组
            int[][] res = new int[R * C][2];
            int resIndex = 0;

            // 同广度队列
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{r0, c0});

            // 是否访问标识
            boolean[][] flag = new boolean[R][C];
            flag[r0][c0] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    res[resIndex++] = poll;

                    // 四个方向
                    for (int[] ints : dir) {
                        int r = poll[0] + ints[0];
                        int c = poll[1] + ints[1];
                        if (r < 0 || r >= R || c < 0 || c >= C) {
                            // 是否越界
                            continue;
                        }

                        if (!flag[r][c]) {
                            flag[r][c] = true;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}