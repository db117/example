package com.db117.example.leetcode.solution;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/9
 **/

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 合并
        System.arraycopy(nums2, 0, nums1, m, n);
        // 排序
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 尾部开始排序
        int p = m + n - 1;
        m--;
        n--;
        // 一直合并到都没有为止
        while (m >= 0 || n >= 0) {
            if (m >= 0 && n >= 0) {
                // 都有的情况
                nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            } else if (m >= 0) {
                // 只有第一个数组有
                nums1[p--] = nums1[m--];
            } else {
                nums1[p--] = nums2[n--];
            }
        }

    }
}
