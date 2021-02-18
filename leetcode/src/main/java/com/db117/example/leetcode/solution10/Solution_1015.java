// 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
//
// 返回 N 的长度。如果不存在这样的 N，就返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：1
//输出：1
//解释：最小的答案是 N = 1，其长度为 1。 
//
// 示例 2： 
//
// 输入：2
//输出：-1
//解释：不存在可被 2 整除的正整数 N 。 
//
// 示例 3： 
//
// 输入：3
//输出：3
//解释：最小的答案是 N = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 10^5 
// 
// Related Topics 数学 
// 👍 33 👎 0


package com.db117.example.leetcode.solution10;

/**
 * 1015.可被 K 整除的最小整数.smallest-integer-divisible-by-k
 *
 * @author db117
 * @since 2021-02-18 15:50:02
 **/

public class Solution_1015 {
    public static void main(String[] args) {
        Solution solution = new Solution_1015().new Solution();
        System.out.println(solution.smallestRepunitDivByK(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRepunitDivByK(int k) {
            if (k % 2 == 0 || k % 5 == 0) {
                // 只有这两种不能被整除
                return -1;
            }
            // 被除数的长度
            int ans = 1;
            // 被除数
            int n = 1;
            // 没有被整除则说明还有
            while (n % k != 0) {
                ans++;
                // 防止越界
                n %= k;
                n = n * 10 + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}