package com.db117.example.leetcode.solution4;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/6/006
 **/
public class Solution494 {

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{
                1, 1, 1, 1, 1
        }, 3));
    }

    // 总数
    int total;
    // 数组
    int[] nums;
    // 目标数
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        bfs(0, 0);

        return total;
    }

    public void bfs(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                // 找到计数
                total++;
            }
            return;
        }
        // 分别加减
        bfs(index + 1, sum + nums[index]);
        bfs(index + 1, sum - nums[index]);
    }
}
