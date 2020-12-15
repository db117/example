//给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,6,4,1]
//输出：false
//解释：不存在连续三个元素都是奇数的情况。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,34,3,4,5,7,23,12]
//输出：true
//解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 
// 👍 5 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1550.存在连续三个奇数的数组.three-consecutive-odds
 *
 * @author db117
 * @since 2020-12-15 16:15:05
 **/

public class Solution1550 {
    public static void main(String[] args) {
        Solution solution = new Solution1550()
                .new Solution();
        System.out.println(solution.threeConsecutiveOdds(new int[]{
                1, 2, 34, 3, 4, 5, 7, 2, 23, 12
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int count = 0;
            for (int i : arr) {
                if (i % 2 == 0) {
                    count = 0;
                } else {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}