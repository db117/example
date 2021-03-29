// 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 
// 👍 351 👎 0


package com.db117.example.leetcode.solution4;

import java.util.LinkedList;
import java.util.List;

/**
 * 442.数组中重复的数据.find-all-duplicates-in-an-array
 *
 * @author db117
 * @since 2021-03-29 15:33:22
 **/

public class Solution_442 {
    public static void main(String[] args) {
        Solution solution = new Solution_442().new Solution();
        System.out.println(solution.findDuplicates(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = Math.abs(nums[i]);
                int index = num - 1;

                if (nums[index] < 0) {
                    // 如果目标的值已经是负数,说明当前是第二次访问目标位置
                    ans.add(num);
                } else {
                    // 第一次把目标位置数字改为负值
                    nums[index] = -nums[index];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}