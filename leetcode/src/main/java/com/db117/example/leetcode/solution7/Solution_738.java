//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 167 👎 0


package com.db117.example.leetcode.solution7;

/**
 * 738.单调递增的数字.monotone-increasing-digits
 *
 * @author db117
 * @since 2021-02-23 10:28:06
 **/

public class Solution_738 {
    public static void main(String[] args) {
        Solution solution = new Solution_738().new Solution();
        System.out.println(solution.monotoneIncreasingDigits(11000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            String s = Integer.toString(N);
            char[] chars = s.toCharArray();
            // 逆序找上一个数字比当前数字大的
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] < chars[i - 1]) {
                    // 上一个数字-1
                    chars[i - 1]--;
                    // 从当前位置开始全是9
                    for (int j = i; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                }
            }
            return Integer.parseInt(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}