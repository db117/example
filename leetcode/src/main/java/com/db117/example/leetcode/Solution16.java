package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author db117
 * @date 2019/6/5
 **/
@Slf4j
public class Solution16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        // 排序
        Arrays.sort(nums);
        // 返回值,差距值
        int res = nums[0] + nums[1] + nums[2];
        // 循环 双指针
        for (int i = 0; i < nums.length; i++) {
            // 左指针,右指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 和比较
                int sum = nums[i] + nums[left] + nums[right];
                int diff = sum - target;
                // 相等返回
                if (diff == 0) {
                    return sum;
                }
                // 保存最接近
                if (Math.abs(res - target) >= Math.abs(diff)) {
                    res = sum;
                }
                if (sum == target) {
                    return res;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
