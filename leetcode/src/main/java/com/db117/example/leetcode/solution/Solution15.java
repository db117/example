package com.db117.example.leetcode.solution;

import java.util.*;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author db117
 * @date 2019/6/3
 **/

public class Solution15 {
    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum1(new int[]{
                -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0
        }));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, 0, 3, 0);
    }

    /**
     * n数之和
     *
     * @param nums   数组
     * @param start  当前索引开始位置
     * @param num    还有几个数字
     * @param target 目标和
     */
    public List<List<Integer>> helper(int[] nums, int start, int num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == 2) {
            int left = start, right = nums.length - 1;
            // 双指针
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // 找到目标添加
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);

                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 移动指针
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return res;
        } else {
            // 遍历剩余数字个数字
            for (int i = start; i < nums.length; i++) {
                // 找到剩下的数字
                List<List<Integer>> temp = helper(nums, i + 1, num - 1, target - nums[i]);

                // 添加当前数字
                for (List<Integer> list : temp) {
                    list.add(nums[i]);
                }
                // 添加到返回值
                res.addAll(temp);
                // 去重
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length < 3) {
            // 不相同的值小于三个直接返回
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            // 同正同负
            return new ArrayList<>();
        }
        if (nums[0] == nums[nums.length - 1]) {
            ArrayList<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(0, 0, 0));
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 负数指针,正数指针
            int left = 0, right = nums.length - 1;
            do {
                // 跳过自己
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                if (left >= right) {
                    break;
                }
                // 过滤掉没有结果的情况
                //
                int sum = nums[left] + nums[right] + num;
                if (sum == 0) {
                    // 找到结果
                    int[] temp = new int[]{num, nums[left], nums[right]};
                    Arrays.sort(temp);
                    res.add(Arrays.asList(temp[0], temp[1], temp[2]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            } while (nums[left] <= 0 && nums[right] >= 0);
        }

        return new ArrayList<>(res);
    }
}
