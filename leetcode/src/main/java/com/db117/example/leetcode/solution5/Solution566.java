//在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
//
// 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。 
//
// 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。 
//
// 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。 
//
// 示例 1: 
//
// 
//输入: 
//nums = 
//[[1,2],
// [3,4]]
//r = 1, c = 4
//输出: 
//[[1,2,3,4]]
//解释:
//行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
// 
//
// 示例 2: 
//
// 
//输入: 
//nums = 
//[[1,2],
// [3,4]]
//r = 2, c = 4
//输出: 
//[[1,2],
// [3,4]]
//解释:
//没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
// 
//
// 注意： 
//
// 
// 给定矩阵的宽和高范围在 [1, 100]。 
// 给定的 r 和 c 都是正数。 
// 
// Related Topics 数组 
// 👍 131 👎 0


package com.db117.example.leetcode.solution5;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 *
 * @author db117
 * @date 2020-08-17 14:04:59
 **/
public class Solution566 {
    public static void main(String[] args) {
        Solution solution = new Solution566().new Solution();
        int[][] nums = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(Arrays.deepToString(
                solution.matrixReshape(nums, 2, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums == null || nums.length == 0 || nums[0].length == 0) {
                return nums;
            }

            int m = nums.length;
            int n = nums[0].length;

            // 不能转换
            if (m * n != r * c) {
                return nums;
            }
            // 一样
            if (m == r && n == c) {
                return nums;
            }

            int[][] res = new int[r][c];
            int index = 0;
            for (int[] num : nums) {
                for (int k = 0; k < n; k++) {
                    // 行
                    int res_r = index / c;
                    // 列
                    int res_c = index % c;
                    res[res_r][res_c] = num[k];
                    index++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}