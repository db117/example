//给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组： 
//
// 
// 目标数组 target 最初为空。 
// 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。 
// 重复上一步，直到在 nums 和 index 中都没有要读取的元素。 
// 
//
// 请你返回目标数组。 
//
// 题目保证数字插入位置总是存在。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
//输出：[0,4,1,3,2]
//解释：
//nums       index     target
//0            0        [0]
//1            1        [0,1]
//2            2        [0,1,2]
//3            2        [0,1,3,2]
//4            1        [0,4,1,3,2]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
//输出：[0,1,2,3,4]
//解释：
//nums       index     target
//1            0        [1]
//2            1        [1,2]
//3            2        [1,2,3]
//4            3        [1,2,3,4]
//0            0        [0,1,2,3,4]
// 
//
// 示例 3： 
//
// 输入：nums = [1], index = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, index.length <= 100 
// nums.length == index.length 
// 0 <= nums[i] <= 100 
// 0 <= index[i] <= i 
// 
// Related Topics 数组 
// 👍 27 👎 0


package com.db117.example.leetcode.solution13;

import java.util.Arrays;

/**
 * 1389.按既定顺序创建目标数组.create-target-array-in-the-given-order
 *
 * @author db117
 * @since 2020-12-18 17:55:28
 **/

public class Solution1389 {
    public static void main(String[] args) {
        Solution solution = new Solution1389().new Solution();
        System.out.println(Arrays.toString(solution.createTargetArray(new int[]{
                0, 1, 2, 3, 4
        }, new int[]{
                0, 1, 2, 2, 1
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            // 找的index中加上后面小于等于个个数
            for (int i = 0; i < index.length; i++) {
                for (int j = i + 1; j < index.length; j++) {
                    if (index[j] <= index[i]) {
                        index[i]++;
                    }
                }
            }

            // 按照位置放好
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[index[i]] = nums[i];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}