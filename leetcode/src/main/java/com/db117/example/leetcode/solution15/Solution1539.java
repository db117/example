//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 哈希表 
// 👍 18 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1539.第 k 个缺失的正整数.kth-missing-positive-number
 *
 * @author db117
 * @since 2020-12-23 16:44:17
 **/

public class Solution1539 {
    public static void main(String[] args) {
        Solution solution = new Solution1539().new Solution();
        System.out.println(solution.findKthPositive(new int[]{
                2
        }, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthPositive(int[] arr, int k) {

            for (int i = 0; i < arr.length; i++) {
                // 当前位置却的正整数的个数
                int num = arr[i] - i - 1;

                if (num >= k) {
                    // arr[i] - (num - k) + 1
                    return k + i;
                }
            }

            //数组走完了,还没有到

            return k + arr.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}