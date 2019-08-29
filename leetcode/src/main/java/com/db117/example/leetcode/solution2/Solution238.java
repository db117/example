package com.db117.example.leetcode.solution2;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/28/028
 */
public class Solution238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[]{
                1, 2, 3, 4
        })));
    }

    public int[] productExceptSelf(int[] nums) {
        // 左边的乘积
        int[] left = new int[nums.length];
        left[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // 右边的乘积
        int pow = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = left[i] * pow;
            pow = pow * temp;
        }
        return nums;
    }
}
