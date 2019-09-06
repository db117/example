package com.db117.example.leetcode.solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/6/006 17:13
 */
public class Solution315 {
    public static void main(String[] args) {
        System.out.println(new Solution315().countSmaller(new int[]{
                5, 2, 1, 1
        }));
    }

    public List<Integer> countSmaller(int[] nums) {
        // 排序使用
        List<Integer> sort = new ArrayList<>();
        // 结果
        Integer[] res = new Integer[nums.length];

        // 倒序二分插入
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = sort.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (sort.get(mid) >= nums[i]) {
                    // 找到比当前数字大的最小数字索引
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = left;
            // 有序
            sort.add(left, nums[i]);
        }
        return Arrays.asList(res);
    }

    // 超时
    public List<Integer> countSmaller1(int[] nums) {
        // 数字->出现的次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

            // 比当前数字小的出现的次数
            nums[i] = treeMap.headMap(num, false)
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();

        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}
