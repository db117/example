// 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 133 👎 0


package com.db117.example.leetcode.solution3;

/**
 * 357.计算各个位数不同的数字个数.count-numbers-with-unique-digits
 *
 * @author db117
 * @since 2021-05-07 16:25:02
 **/

public class Solution_357 {
    public static void main(String[] args) {
        Solution solution = new Solution_357().new Solution();
        int[] arr = {1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691};
        for (int i = 0; i < arr.length; i++) {
            int numbers = solution.countNumbersWithUniqueDigits(i);
            System.out.println(numbers);
            System.out.println(numbers == arr[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n > 10) {
                n = 10;
            }
            // dp
            /*
              排列组合：n位有效数字 = 每一位都从 0~9 中选择，且不能以 0 开头
              1位数字：0~9                      10
              2位数字：C10-2，且第一位不能是0      9 * 9
              3位数字：C10-3，且第一位不能是0      9 * 9 * 8
              4位数字：C10-4，且第一位不能是0      9 * 9 * 8 * 7
              ... ...
              最后，总数 = 所有 小于 n 的位数个数相加
             */

            int one = 10, two = 9 * 9;


            for (int i = 2; i <= n; i++) {
                one += two;
                two *= 10 - i;
            }

            return one;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}