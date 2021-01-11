


//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
// 
//
// 示例2: 
//
// 
// 输入：num = 3
// 输出：3
// 
//
// 提示: 
//
// 
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。 
// 
// Related Topics 位运算 
// 👍 32 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 05.07.配对交换.exchange-lcci
 *
 * @author db117
 * @since 2021-01-11 11:10:02
 **/

public class Interview_0507 {
    public static void main(String[] args) {
        Solution solution = new Interview_0507().new Solution();
        System.out.println(Integer.toBinaryString(solution.exchangeBits(0b1010101011)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int exchangeBits(int num) {
            int odd = num << 1;
            int even = num >> 1;

            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (i % 2 == 0) {
                    // 取偶数的位置
                    ans |= (even & (1 << i));
                } else {
                    // 取奇数位
                    ans |= (odd & (1 << i));
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}