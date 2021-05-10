//给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
//
// 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没
//有下一个结点了。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 示例 3： 
//
// 输入：graph = [[1],[]]
//输出：[[0,1]]
// 
//
// 示例 4： 
//
// 输入：graph = [[1,2,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,2,3],[0,3]]
// 
//
// 示例 5： 
//
// 输入：graph = [[1,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,3]]
// 
//
// 
//
// 提示： 
//
// 
// 结点的数量会在范围 [2, 15] 内。 
// 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。 
// 
// Related Topics 深度优先搜索 图 回溯算法 
// 👍 122 👎 0


package com.db117.example.leetcode.solution7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797.所有可能的路径.all-paths-from-source-to-target
 *
 * @author db117
 * @since 2021-05-08 18:26:16
 **/

public class Solution_797 {
    public static void main(String[] args) {
        Solution solution = new Solution_797().new Solution();


        System.out.println(solution.allPathsSourceTarget(new int[][]{
                // [1,3],[2],[3],[]
                {1, 3},
                {2},
                {3},
                {},
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new LinkedList<>();
        private int[][] graph;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.graph = graph;
            ArrayList<Integer> list = new ArrayList<>(graph.length);
            list.add(0);
            dfs(list, 0);
            return ans;
        }

        private void dfs(List<Integer> list, int cur) {
            int size = list.size();
            if (size > 0 && list.get(size - 1) == graph.length - 1) {
                ans.add(new ArrayList<>(list));
                return;
            }

            // 遍历所有可以去的点
            for (int i : graph[cur]) {

                list.add(i);

                dfs(list, i);
                // 回溯
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}