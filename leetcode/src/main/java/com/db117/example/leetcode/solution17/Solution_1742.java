//你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit
//，即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。 
//
// 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，
//而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。 
//
// 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球
//数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：lowLimit = 1, highLimit = 10
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
//小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
//编号 1 的盒子放有最多小球，小球数量为 2 。 
//
// 示例 2： 
//
// 
//输入：lowLimit = 5, highLimit = 15
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
//小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
//编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
// 
//
// 示例 3： 
//
// 
//输入：lowLimit = 19, highLimit = 28
//输出：2
//解释：
//盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
//小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
//编号 10 的盒子放有最多小球，小球数量为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= lowLimit <= highLimit <= 105 
// 
// Related Topics 数组 
// 👍 2 👎 0


package com.db117.example.leetcode.solution17;

/**
 * 1742.盒子中小球的最大数量.maximum-number-of-balls-in-a-box
 *
 * @author db117
 * @since 2021-02-09 18:13:09
 **/

public class Solution_1742 {
    public static void main(String[] args) {
        Solution solution = new Solution_1742().new Solution();
        System.out.println(solution.countBalls(19, 99998));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            // 最大99999=45
            int[] dp = new int[46];
            // 数组的位置
            int index = sum(lowLimit);
            dp[index]++;

            for (int i = lowLimit + 1; i <= highLimit; i++) {
                int countZero = countZero(i);
                // 当前数字和等于上一个数字和加1-9*后面零的数量
                // F(n)=F(n-1)+1-9*countZero(n)
                index += 1 - 9 * countZero;
                dp[index]++;
            }

            int max = 0;
            for (int i : dp) {
                max = Math.max(max, i);
            }
            return max;
        }


        int sum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        /**
         * 后面有几个连续的0
         */
        int countZero(int n) {
            int count = 0;
            while (n != 0 && n % 10 == 0) {
                count++;
                n /= 10;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}