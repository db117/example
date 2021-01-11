


//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 
// 👍 22 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 05.03.翻转数位.reverse-bits-lcci
 *
 * @author db117
 * @since 2021-01-11 16:12:04
 **/

public class Interview_0503 {
    public static void main(String[] args) {
        Solution solution = new Interview_0503().new Solution();
        System.out.println(Integer.toBinaryString(0));
        System.out.println(solution.reverseBits(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            if (num == -1) {
                return 32;
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= 32; i++) {
                int k = 1 << i;
                if ((num & k) == 0) {
                    // num的第i位为0
                    max = Math.max(max, helper(num | k));
                }
            }
            return max;
        }

        // 最大连续的1的个数
        int helper(int n) {
            int max = 0;
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                } else {
                    max = Math.max(count, max);
                    count = 0;
                }
                n >>>= 1;
            }
            max = Math.max(count, max);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}