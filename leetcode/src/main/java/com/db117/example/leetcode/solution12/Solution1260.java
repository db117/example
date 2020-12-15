//给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。 
//
// 每次「迁移」操作将会引发下述活动： 
//
// 
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。 
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。 
// 
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[9,1,2],[3,4,5],[6,7,8]]
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// 示例 3： 
//
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//输出：[[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 50 
// 1 <= grid[i].length <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics 数组 
// 👍 36 👎 0


package com.db117.example.leetcode.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260.二维网格迁移.shift-2d-grid
 *
 * @author db117
 * @since 2020-12-15 18:15:55
 **/

public class Solution1260 {
    public static void main(String[] args) {
        Solution solution = new Solution1260().new Solution();
        System.out.println(solution.shiftGrid(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                },
                2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            if (k == 0 || (k % (m * n) == 0)) {
                return convert(grid);
            }
            k %= (m * n);

            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 直接加上
                    int x = i;
                    int y = j + k;
                    // 横坐标越界
                    if (y >= n) {
                        // 换行
                        x += (y / n);
                        y %= n;
                    }
                    if (x >= m) {
                        // 纵坐标越界
                        x %= m;
                    }
                    temp[x][y] = grid[i][j];
                }
            }

            return convert(temp);
        }


        // 数组转集合
        public List<List<Integer>> convert(int[][] grid) {
            List<List<Integer>> ans = new ArrayList<>(grid.length);
            int n = grid[0].length;
            for (int[] ints : grid) {
                List<Integer> list = new ArrayList<>(n);
                for (int i : ints) {
                    list.add(i);
                }
                ans.add(list);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}