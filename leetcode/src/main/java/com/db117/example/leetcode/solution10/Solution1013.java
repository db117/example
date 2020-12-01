//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + 
//A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 50000 
// -10^4 <= A[i] <= 10^4 
// 
// Related Topics 数组 
// 👍 125 👎 0


package com.db117.example.leetcode.solution10;

/**
 * 1013.将数组分成和相等的三个部分.partition-array-into-three-parts-with-equal-sum
 *
 * @author db117
 * @since 2020-12-01 10:35:11
 **/

public class Solution1013 {
    public static void main(String[] args) {
        Solution solution = new Solution1013().new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{
                0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int i : A) {
                sum += i;
            }
            if (sum % 3 != 0) {
                return false;
            }
            // 每一段的和
            int n = sum / 3;

            int tempSum = 0;
            // 能分成几段
            int count = 0;
            for (int j : A) {
                tempSum += j;
                if (tempSum == n) {
                    // 找到一段
                    count++;
                    tempSum = 0;
                }
            }
            if (tempSum != 0) {
                // 没有分完
                return false;
            }

            if (n == 0) {
                return count >= 3;
            }
            return count == 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}