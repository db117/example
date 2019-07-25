package com.db117.example.leetcode.solution;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/16
 **/

public class Solution33 {
    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 旋转位置
        int index = findIndex(nums, 0, nums.length - 1);
        // 有序
        if (index == 0) {
            if (nums[0] == target) {
                return 0;
            }
            return bs(nums, 1, nums.length - 1, target);
        }
        // 比最大值还大
        if (target < nums[index]) {
            return -1;
        }
        if (target < nums[0]) {
            // 在旋转点右边
            return bs(nums, index, nums.length - 1, target);
        } else {
            // 在旋转点左边
            return bs(nums, 0, index - 1, target);
        }
    }


    /**
     * 查找旋转位置
     *
     * @param nums  数组
     * @param left  左指针
     * @param right 有指针
     * @return 选择位置
     */
    int findIndex(int[] nums, int left, int right) {
        if (left > right || nums[left] < nums[right]) {
            return 0;
        }
        int mid = (left + right) >>> 1;
        // 找到旋转位置
        if (nums[mid + 1] < nums[mid]) {
            return mid + 1;
        }
        if (nums[left] < nums[mid]) {
            // 左有序,在右边
            return findIndex(nums, mid + 1, right);
        } else {
            // 右有序,在左边
            return findIndex(nums, left, right - 1);
        }
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param left   左指针
     * @param right  右指针
     * @param target 目标
     * @return 目标下标
     */
    int bs(int[] nums, int left, int right, int target) {
        while (left <= right) {
            // 中位数
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
