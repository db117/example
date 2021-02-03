// 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 253 👎 0


package com.db117.example.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.组合总和 III.combination-sum-iii
 *
 * @author db117
 * @since 2021-02-01 14:40:53
 **/

public class Solution_216 {
    public static void main(String[] args) {
        Solution solution = new Solution_216().new Solution();
        System.out.println(solution.combinationSum3(3, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(new ArrayList<>(), 0, k, 0, n);
            return ans;
        }

        void dfs(List<Integer> cur, int num, int k, int sum, int n) {
            if (sum > n || k < 0) {
                return;
            }
            if (sum == n && k == 0) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = num + 1; i <= 9; i++) {
                cur.add(i);
                dfs(cur, i, k - 1, sum + i, n);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}