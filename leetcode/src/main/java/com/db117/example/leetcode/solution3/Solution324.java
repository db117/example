package com.db117.example.leetcode.solution3;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/6/006 16:10
 */
public class Solution324 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 5, 5, 6, 6
        };
        new Solution324().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int[] clone = nums.clone();
        // 倒序穿插
        int left = (nums.length + 1) / 2 - 1;
        int right = nums.length - 1;

        int i = 0;
        while (i < nums.length) {
            if (i % 2 == 0) {
                // 从中间开始倒序插入偶数位
                nums[i++] = clone[left--];
            } else {
                // 从后面开始倒序插入奇数位
                nums[i++] = clone[right--];
            }
        }
    }
}
