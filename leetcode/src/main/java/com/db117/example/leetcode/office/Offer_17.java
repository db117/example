//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 73 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 17.打印从1到最大的n位数.da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 *
 * @author db117
 * @since 2021-01-13 17:53:36
 **/

public class Offer_17 {
    public static void main(String[] args) {
        Solution solution = new Offer_17().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int pow = (int) Math.pow(10, n);
            int[] ans = new int[pow - 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}