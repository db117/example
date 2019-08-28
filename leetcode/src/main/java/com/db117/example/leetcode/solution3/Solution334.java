package com.db117.example.leetcode.solution3;

/**
 * 334. 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/28/028
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        // 第一个数
        int one = Integer.MAX_VALUE;
        // 第二个数
        int two = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= one) {
                // 小于第一个数则第一个数设为改数字
                // 第一个数字一直为最小的
                one = num;
            } else if (num <= two) {
                // 是第二个数尽量的小
                two = num;
            } else {
                // 当大于第二个数字时返回true
                return true;
            }
        }
        return false;
    }
}
