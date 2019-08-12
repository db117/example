package com.db117.example.leetcode.solution3;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 */
public class Solution347 {
    public static void main(String[] args) {
        System.out.println(new Solution347().topKFrequent(new int[]{
                1,1,1,2,2,3
        },2));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 把数组放入到map中
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 设置优先队列排序规则
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get).reversed());
        // 放入优先队列
        queue.addAll(map.keySet());

        // 取队列的前k个数字
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }

        return res;
    }
}
