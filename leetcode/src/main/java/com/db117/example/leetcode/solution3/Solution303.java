package com.db117.example.leetcode.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/21/021 18:08
 */
public class Solution303 {
    class NumArray {
        int[] ints;

        public NumArray(int[] nums) {
            ints = new int[nums.length];

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                // 保存从0开始到当前位置的和
                sum += nums[i];
                ints[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return ints[j];
            } else {
                return ints[j] - ints[i - 1];
            }
        }
    }

    class NumArray1 {
        int[] nums;
        Map<String, Integer> map = new HashMap<>();

        public NumArray1(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            String key = i + "_" + j;
            Integer sum = map.get(key);
            if (sum == null) {
                // 没有计算过,进行计算并返回
                int num = sum(i, j);
                map.put(key, num);
                return num;
            } else {
                // 有缓存直接返回
                return sum;
            }
        }

        public int sum(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
