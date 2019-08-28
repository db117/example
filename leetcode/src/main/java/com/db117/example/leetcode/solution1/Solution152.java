package com.db117.example.leetcode.solution1;

/**
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/22/022
 */
public class Solution152 {
    public static void main(String[] args) {
        System.out.println(new Solution152().maxProduct(new int[]{
                -3, -2, -4, -3
        }));
    }

    public int maxProduct(int[] nums) {
        // 动态规划
        // 保存以当前节点为终点的子序列的最大值,最小值
        int max = nums[0], min = nums[0], cur = nums[0];
        // 从第二个数字开始
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp1 = max * num;
            int temp2 = min * num;
            // 当前值与累计乘积做比较
            max = Math.max(num, Math.max(temp1, temp2));
            min = Math.min(num, Math.min(temp1, temp2));
            // 保存最大值
            cur = Math.max(max, cur);
        }
        return cur;
    }

}
