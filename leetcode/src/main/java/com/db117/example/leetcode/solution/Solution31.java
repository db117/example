package com.db117.example.leetcode.solution;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5→ 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/16
 **/

public class Solution31 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        new Solution31().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        // 倒序找到比下一个数字小的
        int first = -1, second = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                first = i - 1;
                break;
            }
        }
        if (first == -1) {
            // 没有找到直接翻转数组
            swap(nums, 0, nums.length - 1);
            return;
        }

        // 倒序找比第一个数字大的数字
        for (int i = nums.length - 1; i > first; i--) {
            if (nums[i] > nums[first]) {
                second = i;
                break;
            }
        }

        if (second != -1) {
            // 倒序找到比第一个数字大的调换位置
            int tmp = nums[first];
            nums[first] = nums[second];
            nums[second] = tmp;
        }
        // 对第一个数字后面的数组翻转
        swap(nums, first + 1, nums.length - 1);
    }

    /**
     * 把数组从开始结束翻转
     *
     * @param ints  数组
     * @param start 开始下标
     * @param end   结束下标
     */
    void swap(int[] ints, int start, int end) {
        while (start < end) {
            int tmp = ints[start];
            ints[start] = ints[end];
            ints[end] = tmp;
            start++;
            end--;
        }
    }
}
