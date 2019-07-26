package com.db117.example.leetcode.solution4;

/**
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/25/025
 **/
public class Solution485 {
    public static void main(String[] args) {
        System.out.println(new Solution485().findMaxConsecutiveOnes(new int[]{}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        // 1开始的索引
        int index = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                // 碰到0则记录
                max = Math.max(max, i - index);
                index = i + 1;
            } else if (i == nums.length - 1) {
                // 当最后一个为1时
                max = Math.max(max, i - index + 1);
            }
        }

        return max;
    }
}
