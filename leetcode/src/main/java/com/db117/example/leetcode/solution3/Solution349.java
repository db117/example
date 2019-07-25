package com.db117.example.leetcode.solution3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/15
 **/

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1).filter(
                num1 -> Arrays.stream(nums2).anyMatch(num2 -> num1 == num2)
        ).distinct().toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = new HashSet<>();
        // 包含则放入第二个集合中
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        // 转数组
        return set2.stream().mapToInt(i -> i).toArray();
    }
}
