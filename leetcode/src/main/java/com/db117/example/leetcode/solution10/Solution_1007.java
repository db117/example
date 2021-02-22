//在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 ——
//该平铺的每一半上都有一个数字。） 
//
// 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。 
//
// 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。 
//
// 如果无法做到，返回 -1. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
//输出：2
//解释：
//图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
//如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
// 
//
// 示例 2： 
//
// 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
//输出：-1
//解释：
//在这种情况下，不可能旋转多米诺牌使一行的值相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A[i], B[i] <= 6 
// 2 <= A.length == B.length <= 20000 
// 
// Related Topics 贪心算法 数组 
// 👍 65 👎 0


package com.db117.example.leetcode.solution10;

/**
 * 1007.行相等的最少多米诺旋转.minimum-domino-rotations-for-equal-row
 *
 * @author db117
 * @since 2021-02-22 18:21:44
 **/

public class Solution_1007 {
    public static void main(String[] args) {
        Solution solution = new Solution_1007().new Solution();
        // [1,2,1,1,1,2,2,2]
        //[2,1,2,2,2,2,2,2]
        System.out.println(solution.minDominoRotations(new int[]{
                1, 2, 1, 1, 1, 2, 2, 2
        }, new int[]{
                2, 1, 2, 2, 2, 2, 2, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= 6; i++) {
                // 假设相同的数字

                // 是否能换成相同的标记
                boolean flag = true;
                // 每一个数组的数量
                int countA = 0;
                int countB = 0;
                for (int j = 0; j < A.length; j++) {
                    if (i != A[j] && i != B[j]) {
                        // 有一个不相同则不可能旋转多米诺牌使一行的值相等
                        flag = false;
                        break;
                    }
                    // 有两个数组都有的情况
                    if (A[j] == i) {
                        countA++;
                    }
                    if (B[j] == i) {
                        countB++;
                    }
                }

                if (flag) {
                    min = Math.min(min, A.length - Math.max(countA, countB));
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}