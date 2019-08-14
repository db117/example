package com.db117.example.leetcode.solution1;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/13/013
 */
public class Solution154 {
    public static void main(String[] args) {
        System.out.println(new Solution154().findMin(new int[]{
                10, 10, 10, 10, 1, 10
        }));
    }

    public int findMin(int[] nums) {
        // 没有发生旋转
        int num = nums[0];
        if (num < nums[nums.length - 1]) {
            return num;
        }
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int temp = nums[mid];
            if (nums[right] > temp) {
                // 说明旋转点在左边
                right = mid;
            } else if (nums[right] < temp) {
                // 旋转点在右边
                left = mid + 1;
            } else {
                // 如果相等,则只能一步一步移动
                right--;
            }
        }
        return nums[left];
    }
}
