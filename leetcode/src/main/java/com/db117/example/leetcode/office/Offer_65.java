//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//
// 
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
// 👍 108 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 65.不用加减乘除做加法.bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 *
 * @author db117
 * @since 2021-01-15 11:40:41
 **/

public class Offer_65 {
    public static void main(String[] args) {
        Solution solution = new Offer_65().new Solution();
        System.out.println(solution.add(5, 99));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            if (b == 0) {
                return a;
            }
            // a^b 和
            // (a & b) << 1 进位
            return add(a ^ b, (a & b) << 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}