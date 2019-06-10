package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author db117
 * @date 2019/6/10
 **/
@Slf4j
public class Solution18 {
    public static void main(String[] args) {
        System.out.println(new Solution18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return dg(nums, target, 0, 4);
    }

    /**
     * 递归
     *
     * @param nums   有序数组
     * @param target 目标数
     * @param start  开始位置
     * @param sumNum 几数之和
     */
    public List<List<Integer>> dg(int[] nums, int target, int start, int sumNum) {
        List<List<Integer>> res = new LinkedList<>();
        // 结束
        if (start >= nums.length) {
            return res;
        }
        if (sumNum == 2) {
            // 从第二个选定的数开始
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // 找到加入到集合
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum - target > 0) {
                    // 大于目标,右指针左移
                    right--;
                } else {
                    // 小于目标,左指针右移
                    left++;
                }
            }
            return res;
        } else if (sumNum > 2) {
            for (int i = start; i < nums.length - sumNum + 1; i++) {
                // 递归调用查找
                List<List<Integer>> dg = dg(nums, target - nums[i], i + 1, sumNum - 1);
                // 添加本次循环选择的值
                for (List<Integer> integers : dg) {
                    integers.add(nums[i]);
                }
                res.addAll(dg);
                // 去重
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
