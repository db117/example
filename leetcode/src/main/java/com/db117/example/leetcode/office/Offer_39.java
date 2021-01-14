//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
//
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 102 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 39.数组中出现次数超过一半的数字.shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-14 11:44:38
 **/

public class Offer_39 {
    public static void main(String[] args) {
        Solution solution = new Offer_39().new Solution();
        System.out.println(solution.majorityElement(new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {

            // 摩尔投票
            int ans = nums[0], count = 0;
            for (int num : nums) {
                if (count == 0) {
                    ans = num;
                    count++;
                } else {
                    if (ans == num) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}