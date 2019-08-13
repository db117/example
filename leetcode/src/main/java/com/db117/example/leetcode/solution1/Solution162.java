package com.db117.example.leetcode.solution1;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/13/013
 */
public class Solution162 {
    public static void main(String[] args) {
        System.out.println(new Solution162().findPeakElement(new int[]{
                Integer.MIN_VALUE + 1, Integer.MIN_VALUE
        }));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 中位数前面
            long pre = mid > 0 ? nums[mid - 1] : Long.MIN_VALUE;
            // 中位数后面
            long next = mid < nums.length - 1 ? nums[mid + 1] : Long.MIN_VALUE;
            int temp = nums[mid];

            if (temp > pre && temp > next) {
                return mid;
            } else if (pre < next) {
                // 后面比前面大,峰值在后面
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return right;
    }
}
