


//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 16 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 05.06.整数转换.convert-integer-lcci
 *
 * @author db117
 * @since 2021-01-11 11:05:32
 **/

public class Interview_0506 {
    public static void main(String[] args) {
        Solution solution = new Interview_0506().new Solution();

        System.out.println(solution.convertInteger(29, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int A, int B) {
            return Integer.bitCount(A ^ B);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}