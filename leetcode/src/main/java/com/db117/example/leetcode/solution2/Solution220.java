package com.db117.example.leetcode.solution2;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t
 * ，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/15
 **/
@Slf4j
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 找到比当前值大的最小值
            Integer ceiling = treeSet.ceiling(num);
            if (ceiling != null && (long) ceiling - (long) num <= t) {
                // 差小于给定值
                return true;
            }

            // 找到比当前值小的最大值
            Integer floor = treeSet.floor(num);
            if (floor != null && (long) num - (long) floor <= t) {
                return true;
            }

            treeSet.add(num);
            // 保持treeset小于等于k
            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
