//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
//
// （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。） 
//
// 示例 1: 
//
// 
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
// 
//
// 示例 2: 
//
// 
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
// 
//
// 注意: 
//
// 
// L, R 是 L <= R 且在 [1, 10^6] 中的整数。 
// R - L 的最大值为 10000。 
// 
// Related Topics 位运算 
// 👍 49 👎 0

package com.db117.example.leetcode.solution7;

/**
 * 762.二进制表示中质数个计算置位.prime-number-of-set-bits-in-binary-representation
 *
 * @author db117
 * @date 2020-10-10 11:48:00
 **/
public class Solution762 {
    public static void main(String[] args) {
        Solution solution = new Solution762().new Solution();
        System.out.println(solution.countPrimeSetBits(10, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimeSetBits(int L, int R) {
            // 小于10^6 即20以下的质数
            // 665772 用bit保存是否能访问
            int m = 665772;
            int res = 0;

            for (int i = L; i <= R; i++) {
                res += m >> Integer.bitCount(i) & 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}