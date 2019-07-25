package com.db117.example.leetcode.solution;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/21
 **/

public class Solution45 {
    public static void main(String[] args) {
        System.out.println(new Solution45().jump(new int[]{1, 1, 1, 1, 1}));
    }

    public int jump(int[] nums) {
        int step = 0;
        // 右边边界
        int end = 0;
        // 最大步数
        int max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 保存最大步数
            max = Math.max(i + nums[i], max);
            // 当到上一次跳跃的最大位置,时跳max个位置
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }


    // 超时
    public int jump1(int[] nums) {
        int index = nums.length - 1;
        int step = 0;

        // 从右往左前找
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                // 每次从左往右遍历,如果大于等于当前与目标位置的差,跳过去
                if (nums[i] >= index - i) {
                    index = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
