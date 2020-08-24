//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表 
// 👍 117 👎 0


package com.db117.example.leetcode.solution5;

import java.util.HashMap;
import java.util.Map;

/**
 * 594.最长和谐子序列
 *
 * @author db117
 * @date 2020-08-24 15:39:06
 **/
public class Solution594 {
    public static void main(String[] args) {
        Solution solution = new Solution594().new Solution();
        System.out.println(solution.findLHS(new int[]{
                1, 3, 2, 2, 5, 2, 3, 7
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            // 记录每个数字出现的次数
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int res = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                // 记录相差一的数量
                if (map.get(k - 1) != null) {
                    res = Math.max(res, map.get(k - 1) + v);
                }

                if (map.get(k + 1) != null) {
                    res = Math.max(res, map.get(k + 1) + v);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}