


//给定两个32位的整数N与M，以及表示比特位置的i与j（j >= i）。编写一种方法，将M插入N，使得N从第j位到第i位的比特与M的前j-i+1个比特相同。 
//
//
// 你可以假定从j位到i位足以容纳M，即若M = 10011，那么j和i之间至少可容纳5个位，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放
//不下M。 
//
// 示例1: 
//
// 
// 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
// 输出：N = 1100(10001001100)
// 
//
// 示例2: 
//
// 
// 输入： N = 0, M = 31(11111), i = 0, j = 4
// 输出：N = 31(11111)
// 
// Related Topics 位运算 
// 👍 21 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 05.01.插入.insert-into-bits-lcci
 *
 * @author db117
 * @since 2021-01-08 18:54:08
 **/

public class Interview_0501 {
    public static void main(String[] args) {
        Solution solution = new Interview_0501().new Solution();
        System.out.println(solution.insertBits(1024, 19, 2, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int insertBits(int N, int M, int i, int j) {

            int n = 0;
            for (int k = i; k <= j; k++) {
                n |= (1 << k);
            }
            // n= ...000111...000...
            // 取反 ...111000...111...
            n = ~n;

            // 把N的i到j全弄成0
            N &= n;

            // 把M插入到N中
            M <<= i;
            return N | M;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}