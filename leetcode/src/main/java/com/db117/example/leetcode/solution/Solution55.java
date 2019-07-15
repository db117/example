package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/27
 **/
@Slf4j
public class Solution55 {
    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i == nums.length - 1) {
                    // 最后一个是0
                    return true;
                }
                // 找到0
                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > i - j) {
                        // 有能跳的当前位置的
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    // 没有等跳到0位置
                    return false;
                }
            }
        }
        return true;
    }
}
