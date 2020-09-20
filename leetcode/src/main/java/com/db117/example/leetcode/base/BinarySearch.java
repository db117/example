package com.db117.example.leetcode.base;

/**
 * 二分搜索
 *
 * @author db117
 * @date 2020/9/20/020 14:26
 **/
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        System.out.println(search.bsRight(new int[]{
                        1, 2, 3, 4, 5, 9, 9, 9, 9, 9, 11, 15
                },
                9));
    }

    /**
     * 精准查询,查询不到返回-1
     */
    public int bs(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 偶数取左边
            int mid = left + ((right - left) >> 1);

            int num = nums[mid];
            if (num == target) {
                // 找到返回
                return mid;
            } else if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else {
                // 移动右边界
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 找到最左边的索引,找不到返回-1
     */
    public int bsLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else if (num > target) {
                // 移动右边界
                right = mid - 1;
            } else {
                // 锁定左边
                right = mid - 1;
            }
        }
        // 检查越界,是否找到
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 查找最左边的索引,找不到返回-1
     */
    public int bsRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (num < target) {
                // 移动左边界
                left = mid + 1;
            } else if (num > target) {
                // 移动右边界
                right = mid - 1;
            } else {
                // 锁定右边,移动左边界
                left = mid + 1;
            }
        }
        // 检查越界,是否找到
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
