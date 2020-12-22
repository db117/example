//给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。 
//
// 
//
// 示例 1： 
//
// 输入：low = 3, high = 7
//输出：3
//解释：3 到 7 之间奇数数字为 [3,5,7] 。 
//
// 示例 2： 
//
// 输入：low = 8, high = 10
//输出：1
//解释：8 到 10 之间奇数数字为 [9] 。 
//
// 
//
// 提示： 
//
// 
// 0 <= low <= high <= 10^9 
// 
// Related Topics 数学 
// 👍 11 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1523.在区间范围内统计奇数数目.count-odd-numbers-in-an-interval-range
 *
 * @author db117
 * @since 2020-12-22 17:52:23
 **/

public class Solution1523 {
    public static void main(String[] args) {
        Solution solution = new Solution1523().new Solution();
        System.out.println(solution.countOdds(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countOdds(int low, int high) {
            // 把low high定位到(区间内奇数)外的偶数上
            if (low % 2 == 1) {
                low--;
            }
            if (high % 2 == 1) {
                high++;
            }

            return (high - low) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}