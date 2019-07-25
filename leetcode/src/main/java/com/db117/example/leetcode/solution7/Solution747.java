package com.db117.example.leetcode.solution7;

import java.util.Map;
import java.util.TreeMap;

/**
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *  
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/25/025
 **/

public class Solution747 {
    public static void main(String[] args) {
        System.out.println(new Solution747().dominantIndex1(new int[]{3, 6, 1, 0}));
    }

    public int dominantIndex1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 最大值
        int max = Integer.MIN_VALUE;
        // 第二大
        int sec = Integer.MIN_VALUE;
        // 最大值位置
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        if (max >= sec * 2) {
            return index;
        }
        return -1;
    }
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // k->值 v->位置
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // 放入treemap中
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], i);
        }
        // 找到最大的那个数字,以及其位置
        Map.Entry<Integer, Integer> firstEntry = treeMap.lastEntry();
        // 找到比最大值小的最大值
        Integer lowerKey = treeMap.lowerKey(firstEntry.getKey());
        // 是否是其二倍大
        if (firstEntry.getKey() >= lowerKey * 2) {
            return firstEntry.getValue();
        }

        return -1;
    }
}
