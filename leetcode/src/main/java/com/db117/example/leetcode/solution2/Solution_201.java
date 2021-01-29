//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 260 👎 0


package com.db117.example.leetcode.solution2;

/**
 * 201.数字范围按位与.bitwise-and-of-numbers-range
 *
 * @author db117
 * @since 2021-01-29 18:46:50
 **/

public class Solution_201 {
    public static void main(String[] args) {
        Solution solution = new Solution_201().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            // 有一位不为0则都不为0
            // 相等即为公共前缀
            while (m != n) {
                m >>= 1;
                n >>= 1;
                shift++;
            }
            return m << shift;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}