//在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。 
//
// 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。 
//
// 投影就像影子，将三维形体映射到一个二维平面上。 
//
// 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。 
//
// 返回所有三个投影的总面积。
//
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[2]]
//输出：5
// 
//
// 示例 2： 
//
// 输入：[[1,2],[3,4]]
//输出：17
//解释：
//这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
//
// 
//
// 示例 3： 
//
// 输入：[[1,0],[0,2]]
//输出：8
// 
//
// 示例 4： 
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：14
// 
//
// 示例 5： 
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：21
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length = grid[0].length <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 数学 
// 👍 45 👎 0


package com.db117.example.leetcode.solution8;

import java.util.Arrays;

/**
 * 883.三维形体投影面积.projection-area-of-3d-shapes
 *
 * @author db117
 * @since 2020-11-10 10:24:09
 **/

public class Solution883 {
    public static void main(String[] args) {
        Solution solution = new Solution883().new Solution();
        System.out.println(solution.projectionArea(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int projectionArea(int[][] grid) {
            int len = grid[0].length;
            // 正面观察
            int[] xMax = new int[len];
            // 侧面观察
            int[] yMax = new int[len];
            // 上面观察(1 或者 0)
            int[] zMax = new int[len * len];

            for (int i = 0; i < grid.length; i++) {
                int[] ints = grid[i];
                for (int j = 0; j < ints.length; j++) {
                    int n = ints[j];
                    // 正面观察
                    xMax[i] = Math.max(xMax[i], n);
                    // 侧面观察
                    yMax[j] = Math.max(yMax[j], n);
                    if (n > 0) {
                        // 俯视
                        zMax[i * len + j] = 1;
                    }
                }
            }

            return Arrays.stream(xMax).sum() + Arrays.stream(yMax).sum() + Arrays.stream(zMax).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}