//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 
// 👍 29 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 17.01.不用加号的加法.add-without-plus-lcci
 *
 * @author db117
 * @since 2021-01-22 10:25:58
 **/

public class Interview_1701 {
    public static void main(String[] args) {
        Solution solution = new Interview_1701().new Solution();
        System.out.println(solution.add(7, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            if (b == 0) {
                return a;
            }
            // a^b 相当于不进位加
            // (a&b)<<1 相当与进位
            return add(a ^ b, (a & b) << 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}