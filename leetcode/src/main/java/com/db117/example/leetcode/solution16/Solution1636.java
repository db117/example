//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
// Related Topics 排序 数组 
// 👍 11 👎 0


package com.db117.example.leetcode.solution16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1636.按照频率将数组升序排序.sort-array-by-increasing-frequency
 *
 * @author db117
 * @since 2020-12-30 20:24:54
 **/

public class Solution1636 {
    public static void main(String[] args) {
        Solution solution = new Solution1636().new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{
                2, 3, 1, 3, 2
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            // 记录数字出现的次数
            int[] flag = new int[201];
            for (int num : nums) {
                flag[num + 100]++;
            }

            // 找到个个频次的数字
            // 索引为频次
            List<Integer>[] lists = new List[101];

            for (int i = flag.length - 1; i >= 0; i--) {
                // 倒序放入
                int count = flag[i];
                if (count == 0) {
                    continue;
                }
                int num = i - 100;

                List<Integer> list = lists[count];
                if (list == null) {
                    lists[count] = new ArrayList<>();
                    lists[count].add(num);
                } else {
                    list.add(num);
                }

            }

            // 拼接返回数组
            int[] ans = new int[nums.length];
            int index = 0;
            for (int j = 1, len = lists.length; j < len; j++) {
                List<Integer> list = lists[j];
                if (list != null) {
                    for (Integer i : list) {
                        // 放入的时候已经排好序了
                        for (int k = 0; k < j; k++) {
                            ans[index++] = i;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}