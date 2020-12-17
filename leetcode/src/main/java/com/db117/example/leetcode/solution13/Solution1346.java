//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 
// 👍 30 👎 0


package com.db117.example.leetcode.solution13;

import java.util.Arrays;

/**
 * 1346.检查整数及其两倍数是否存在.check-if-n-and-its-double-exist
 *
 * @author db117
 * @since 2020-12-17 15:30:08
 **/

public class Solution1346 {
    public static void main(String[] args) {
        Solution solution = new Solution1346().new Solution();
        System.out.println(solution.checkIfExist(new int[]{
                -2, 0, 10, -19, 4, 6, -8
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                int bs = bs(arr, arr[i] * 2);
                // 找到且不是自己,(0*2=0)
                if (bs != -1 && bs != i) {
                    return true;
                }
            }
            return false;
        }


        private int bs(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                int n = arr[mid];
                if (n == target) {
                    return mid;
                } else if (n < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}