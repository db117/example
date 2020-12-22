//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 排序 数组 
// 👍 8 👎 0


package com.db117.example.leetcode.solution15;

/**
 * 1502.判断能否形成等差数列.can-make-arithmetic-progression-from-sequence
 *
 * @author db117
 * @since 2020-12-22 17:29:54
 **/

public class Solution1502 {
    public static void main(String[] args) {
        Solution solution = new Solution1502().new Solution();
        System.out.println(solution.canMakeArithmeticProgression(new int[]{
                0, 0, 0, 0, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            if (arr.length == 2) {
                return true;
            }
            // 找到最大值,最小值
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i : arr) {
                max = Math.max(i, max);
                min = Math.min(min, i);
            }
            int n = max - min;
            // 不能整除,则不可能是等差数列
            if ((n % (arr.length - 1)) != 0) {
                return false;
            }

            // 差值
            n = n / (arr.length - 1);

            if (n == 0) {
                // 最大值=最小值
                return true;
            }

            // 标记是否已经存在
            boolean[] flag = new boolean[arr.length];
            for (int i : arr) {
                // 如果不能被整除,则不是等差数列
                if ((i - min) % n != 0) {
                    return false;
                }

                // 这个数字已经存在过
                int index = (i - min) / n;
                if (flag[index]) {
                    return false;
                }
                flag[index] = true;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}