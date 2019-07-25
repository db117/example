package com.db117.example.leetcode.solution;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/

public class Solution81 {
    public static void main(String[] args) {
        System.out.println(new Solution81().search(new int[]{5, 1, 2}, 2));
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 二分
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                // 如果中间等于两端,缩小范围
                right--;
                left++;
                continue;
            }

            // 左侧有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    // 目标在左侧有序部分
                    right = mid - 1;
                } else {
                    // 目标在右侧无序部分
                    left = mid + 1;
                }
            } else {
                // 左边无序则右侧有序
                if (nums[mid] <= target && target <= nums[right]) {
                    // 目标在右侧有序部分
                    left = mid + 1;
                } else {
                    // 目标在左侧无序部分
                    right = mid - 1;
                }

            }
        }
        return false;
    }
}
