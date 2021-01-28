

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 678 👎 0


package com.db117.example.leetcode.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 120.三角形最小路径和.triangle
 *
 * @author db117
 * @since 2021-01-26 17:03:31
 **/

public class Solution_120 {
    public static void main(String[] args) {
        Solution solution = new Solution_120().new Solution();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>() {{
            add(2);
        }});
        list.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        list.add(new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }});
        list.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});

        System.out.println(solution.minimumTotal(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int size = triangle.size();
            // 从下往上开始
            int[][] dp = new int[size + 1][size + 1];
            for (int i = size - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    // 算出当前位置的最小值
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}