//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 378 👎 0


package com.db117.example.leetcode.solution5;

/**
 * 581.最短无序连续子数组
 *
 * @author db117
 * @date 2020-08-24 11:45:20
 **/
public class Solution581 {
    public static void main(String[] args) {
        Solution solution = new Solution581().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{
                1, 2, 3, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // 寻找最左边的存在右边有比该值小的
            // 寻找最右边的存在左边有比该值大的

            int len = nums.length;
            int tmp = Integer.MIN_VALUE;
            // 右边界
            int ri = 0;
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                if (num < tmp) {
                    ri = i;
                }
                tmp = Math.max(tmp, num);
            }

            if (ri == 0) {
                // 本来就是有序的
                return 0;
            }
            // 右边界
            tmp = Integer.MAX_VALUE;
            int li = len - 1;
            for (int i = len - 1; i >= 0; i--) {
                int num = nums[i];
                if (num > tmp) {
                    li = i;
                }
                tmp = Math.min(tmp, num);
            }
            return ri - li + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}