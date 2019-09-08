package com.db117.example.leetcode.solution1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/8/008 15:42
 */
public class Solution128 {
    public static void main(String[] args) {
        System.out.println(new Solution128().longestConsecutive(new int[]{
                100, 4, 200, 1, 3, 2
        }));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;
        // 遍历所有数字
        for (int num : nums) {
            // 找到以当前数字开始的数字
            if (!set.contains(num - 1)) {
                // 计算最大值
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
