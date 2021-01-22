//数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
//
// 注意：本题相对书上原题稍作改动 
//
// 示例 1： 
//
// 输入：[3,0,1]
//输出：2 
//
// 
//
// 示例 2： 
//
// 输入：[9,6,4,2,3,5,7,0,1]
//输出：8
// 
// Related Topics 位运算 数组 数学 
// 👍 33 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 17.04.消失的数字.missing-number-lcci
 *
 * @author db117
 * @since 2021-01-22 10:56:45
 **/

public class Interview_1704 {
    public static void main(String[] args) {
        Solution solution = new Interview_1704().new Solution();
        System.out.println(solution.missingNumber(new int[]{
                3, 0, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            // a^a=0
            // 0^a=a
            // 只有缺失的那个数字出现了一次,其他数字出现了两次

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans ^= i + 1;
                ans ^= nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}