package com.db117.example.leetcode.solution2;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/15
 **/

public class Solution283 {
    public void moveZeroes(int[] nums) {
        // 待交换0
        int left = 0;
        // 待交换的非0
        int right = 0;

        // 找到第一个0
        for (; left < nums.length; left++) {
            if (nums[left] == 0) {
                break;
            }
        }

        right = left + 1;
        // 找到后面第一个非0
        while (right < nums.length) {
            if (nums[right] != 0) {
                // 找到第一个非0后则交换
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }
}
