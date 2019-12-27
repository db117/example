package com.db117.example.leetcode.solution8;

/**
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/26/026 15:52
 */
public class Solution892 {
    public static void main(String[] args) {
        System.out.println(new Solution892().surfaceArea(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }));
    }

    public int surfaceArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int high = grid[i][j];
                if (high == 0) {
                    continue;
                }
                // 假设每一个都是独立的
                ans += high * 4 + 2;

                // 去掉有接触的
                if (i > 0) {
                    ans -= Math.min(grid[i - 1][j], high);
                }
                if (i < grid.length - 1) {
                    ans -= Math.min(grid[i + 1][j], high);
                }
                if (j > 0) {
                    ans -= Math.min(grid[i][j - 1], high);
                }
                if (j < grid[0].length - 1) {
                    ans -= Math.min(grid[i][j + 1], high);
                }
            }
        }

        return ans;
    }
}
