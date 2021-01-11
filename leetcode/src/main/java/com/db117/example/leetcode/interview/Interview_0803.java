


//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 说明: 
//
// 
// nums长度在[1, 1000000]之间 
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本 
// 
// Related Topics 数组 二分查找 
// 👍 79 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 08.03.魔术索引.magic-index-lcci
 *
 * @author db117
 * @since 2021-01-11 16:33:11
 **/

public class Interview_0803 {
    public static void main(String[] args) {
        Solution solution = new Interview_0803().new Solution();
        System.out.println(solution.findMagicIndex(new int[]{
                0, 2, 3, 4, 5
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMagicIndex(int[] nums) {
            int n = 0;
            while (n < nums.length) {
                if (nums[n] == n) {
                    // 找到直接返回
                    return n;
                } else if (nums[n] > n) {
                    // 如果值大于索引,则说明值所在的位置之前没有魔术索引
                    n = nums[n];
                } else {
                    // 值小与索引,则只能一点一点的加
                    n++;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}