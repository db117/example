


//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 72 👎 0


package com.db117.example.leetcode.office;

import java.util.Arrays;

/**
 * 剑指 Offer 21.调整数组顺序使奇数位于偶数前面.diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 *
 * @author db117
 * @since 2021-01-13 15:41:08
 **/

public class Offer_21 {
    public static void main(String[] args) {
        Solution solution = new Offer_21().new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{
                2, 3
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // 找到左边第一个偶数
                while (left < right && nums[left] % 2 == 1) {
                    left++;
                }
                // 找到右边第一个奇数
                while (right > left && nums[right] % 2 == 0) {
                    right--;
                }
                if (left == right) {
                    continue;
                }
                // 交换
                nums[left] ^= nums[right];
                nums[right] ^= nums[left];
                nums[left] ^= nums[right];
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}