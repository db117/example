//设计一个算法，算出 n 阶乘有多少个尾随零。
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 32 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 16.05.阶乘尾数.factorial-zeros-lcci
 *
 * @author db117
 * @since 2021-01-21 18:08:04
 **/

public class Interview_1605 {
    public static void main(String[] args) {

        Solution solution = new Interview_1605().new Solution();

        System.out.println(solution.trailingZeroes(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            // 找相乘因子中 10 的数量
            // 2*5的个数

            int ans = 0;
            while (n > 0) {
                n /= 5;
                ans += n;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}