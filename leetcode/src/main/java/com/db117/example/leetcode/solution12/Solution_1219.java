//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。 
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金： 
//
// 
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。 
// 矿工每次可以从当前位置向上下左右四个方向走。 
// 每个单元格只能被开采（进入）一次。 
// 不得开采（进入）黄金数目为 0 的单元格。 
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。 
// 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
// 
//
// 示例 2： 
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 15 
// 0 <= grid[i][j] <= 100 
// 最多 25 个单元格中有黄金。 
// 
// Related Topics 回溯算法
// 👍 74 👎 0


package com.db117.example.leetcode.solution12;

/**
 * 1219.黄金矿工.path-with-maximum-gold
 *
 * @author db117
 * @since 2021-05-13 18:28:34
 **/

public class Solution_1219 {
    public static void main(String[] args) {
        Solution solution = new Solution_1219().new Solution();
        // [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        // [0,6,0],[5,8,7],[0,9,0]
//        System.out.println(solution.getMaximumGold(new int[][]{
//                {1, 0, 7},
//                {2, 0, 6},
//                {3, 4, 5},
//                {0, 3, 0},
//                {9, 0, 20}
//        }));
        System.out.println(solution.getMaximumGold(new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0},
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int max = -1;
        // 方向
        int[][] tmp = new int[][]{
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1}
        };

        public int getMaximumGold(int[][] grid) {
            this.grid = grid;


            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {
                        // 从每一个不为 0 的位置开始
                        dfs(i, j, 0);
                    }
                }
            }
            return max;
        }

        private void dfs(int x, int y, int sum) {
            // 走到当前点,则当前位置索引肯定合法
            sum += grid[x][y];
            max = Math.max(max, sum);

            for (int[] ints : tmp) {
                int temp = grid[x][y];
                // 标记为 0 代替标记,不会走回头路
                grid[x][y] = 0;

                int nx = x + ints[0];
                int ny = y + ints[1];
                if (nx < 0
                        || ny < 0
                        || nx >= grid.length
                        || ny >= grid[0].length
                        || grid[nx][ny] == 0) {
                    // 一定要回溯
                    grid[x][y] = temp;
                    continue;
                }

                dfs(nx, ny, sum);

                grid[x][y] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}