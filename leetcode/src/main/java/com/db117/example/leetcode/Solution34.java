package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/17
 **/
@Slf4j
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        // 二分查找
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                // 找到后往左右继续查找
                left = right = mid;
                while (left > 0 && nums[left] == nums[left - 1]) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right++;
                }
                res[0] = left;
                res[1] = right;
                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
