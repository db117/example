package com.db117.example.leetcode.solution3;

import java.util.Random;

/**
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/22/022
 **/

public class Solution384 {
    int[] reset;
    int[] shuffle;
    private Random rand = new Random();

    public Solution384(int[] nums) {
        this.reset = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return reset;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // 复制数组
        shuffle = reset.clone();
        // 随机选择一个数字放到后面
        // 前面都是未选择过的
        // 理论上是随机的
        for (int i = shuffle.length - 1; i >= 0; i--) {
            swap(shuffle, rand.nextInt(i + 1), i);
        }
        return shuffle;
    }

    /**
     * 交换数组的数据
     */
    public void swap(int[] nums, int left, int right) {
        if (left != right) {
            int num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
        }
    }
}
