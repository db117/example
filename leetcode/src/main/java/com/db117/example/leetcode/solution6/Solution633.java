//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学 
// 👍 136 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 633.平方数之和
 *
 * @author db117
 * @date 2020-08-24 17:47:52
 **/
public class Solution633 {
    public static void main(String[] args) {
        Solution solution = new Solution633().new Solution();
        System.out.println(solution.judgeSquareSum(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            for (long i = 0; i * i <= c; i++) {
                long n = c - i * i;
                // 二分查找,找到是否存在某个数字的平方是n
                if (bs(0, n, n)) {
                    return true;
                }
            }
            return false;
        }

        boolean bs(long start, long end, long n) {
            if (start > end) {
                return false;
            }

            long mid = (start + end) >> 1;
            long t = mid * mid;
            if (t == n) {
                return true;
            }
            if (t > n) {
                return bs(start, mid - 1, n);
            }
            return bs(mid + 1, end, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}