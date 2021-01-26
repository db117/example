//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 961 👎 0


package com.db117.example.leetcode.solution;

/**
 * 96.不同的二叉搜索树.unique-binary-search-trees
 *
 * @author db117
 * @since 2021-01-22 15:31:04
 **/

public class Solution_96 {
    public static void main(String[] args) {
        Solution solution = new Solution_96().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            // 把某个数字当成root,则其组合数为左边的可能*右边的可能
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}