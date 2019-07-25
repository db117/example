package com.db117.example.leetcode.solution;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/19
 **/

public class Solution41 {
    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{1, 2, 0}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        // 把在数字放在数组的位置
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num - 1 == i) {
                continue;
            }
            // 当已经放好,或者越界
            if (num < 1 || num > nums.length || nums[num - 1] == num) {
                nums[i] = 0;
                continue;
            }
            // 交换并是i减1,从当前位置继续处理
            swap(nums, num - 1, i--);
        }
        // 找到第一个数字不是数组位置的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }


    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
