//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组 
// 👍 171 👎 0

package com.db117.example.leetcode.solution6;

import java.util.HashMap;
import java.util.Map;

/**
 * 697.数组的度.degree-of-an-array
 *
 * @author db117
 * @date 2020-09-30 11:40:20
 **/
public class Solution697 {
    public static void main(String[] args) {
        Solution solution = new Solution697().new Solution();
        System.out.println(solution.findShortestSubArray(new int[]{
                1, 2, 2, 3, 1, 4, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            // 计数
            Map<Integer, Integer> count = new HashMap<>();
            // 最小索引
            Map<Integer, Integer> left = new HashMap<>();
            // 最大索引
            Map<Integer, Integer> right = new HashMap<>();

            // 最大的出现次数
            int maxCount = 0;
            for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
                int num = nums[i];
                count.put(num, count.getOrDefault(num, 0) + 1);

                left.putIfAbsent(num, i);

                right.put(num,  i);

                maxCount = Math.max(maxCount, count.get(num));
            }

            int res = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                Integer key = entry.getKey();
                // 最大出现次数,最大索引-最小索引
                if (entry.getValue().equals(maxCount)) {
                    res = Math.min(res, right.get(key) - left.get(key));
                }
            }
            return res + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}