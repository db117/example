


//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 248 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 03.数组中重复的数字.shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-12 10:53:55
 **/

public class Offer_03 {
    public static void main(String[] args) {
        Solution solution = new Offer_03().new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{
                2, 3, 1, 0, 4, 5, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间O(n) ,空间O(1)
        public int findRepeatNumber(int[] nums) {
            // 把当前值的索引位置的数值加上1000000,如果有值大于等于1000000的则说明有重复的
            for (int num : nums) {
                // 取模,防止溢出
                num %= 1000000;
                if (nums[num] >= 1000000) {
                    return num;
                }
                nums[num] += 1000000;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}