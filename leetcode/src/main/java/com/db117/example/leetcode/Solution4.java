package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author db117
 * @date 2019/5/13
 **/
@Slf4j
public class Solution4 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, ints, nums1.length, nums2.length);
        Arrays.parallelSort(ints);
        int length = ints.length;
        if (length % 2 == 0) {
            return (ints[ints.length / 2 - 1] + ints[ints.length / 2]) / 2d;
        }
        return ints[ints.length / 2];
    }
}
