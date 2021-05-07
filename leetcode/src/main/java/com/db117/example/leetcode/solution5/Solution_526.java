//假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，
//我们就称这个数组为一个优美的排列。条件： 
//
// 
// 第 i 位的数字能被 i 整除 
// i 能被第 i 位上的数字整除 
// 
//
// 现在给定一个整数 N，请问可以构造多少个优美的排列？ 
//
// 示例1: 
//
// 
//输入: 2
//输出: 2
//解释: 
//
//第 1 个优美的排列是 [1, 2]:
//  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
//
//第 2 个优美的排列是 [2, 1]:
//  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// 
//
// 说明: 
//
// 
// N 是一个正整数，并且不会超过15。 
// 
// Related Topics 深度优先搜索 回溯算法 
// 👍 134 👎 0


package com.db117.example.leetcode.solution5;

/**
 * 526.优美的排列.beautiful-arrangement
 *
 * @author db117
 * @since 2021-05-07 16:05:04
 **/

public class Solution_526 {
    public static void main(String[] args) {

        // 0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679
        int[] ans = new int[]{0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        for (int i = 1; i < ans.length; i++) {
            Solution solution = new Solution_526().new Solution();
            int count = solution.countArrangement(i);

            System.out.println(count);
            System.out.println(count == ans[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int count;

        public int countArrangement(int n) {
            dfs(1, new boolean[n + 1]);
            return count;
        }

        private void dfs(int index, boolean[] flags) {
            if (index == flags.length) {
                count++;
                return;
            }

            for (int i = 1; i < flags.length; i++) {
                if (!flags[i]) {
                    if (index % i == 0 || i % index == 0) {
                        flags[i] = true;
                        dfs(index + 1, flags);
                        flags[i] = false;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}