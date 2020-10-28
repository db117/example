//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 数学 
// 👍 67 👎 0

package com.db117.example.leetcode.solution8;

/**
 * 812.最大三角形面积.largest-triangle-area
 *
 * @author db117
 * @date 2020-10-28 16:22:04
 **/
public class Solution812 {
    public static void main(String[] args) {
        Solution solution = new Solution812().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double res = 0;
            //鞋带公式
            int len = points.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        double area = (points[i][0] * points[j][1] +
                                points[j][0] * points[k][1] +
                                points[k][0] * points[i][1] -
                                points[i][1] * points[j][0] -
                                points[j][1] * points[k][0] -
                                points[k][1] * points[i][0]) / 2d;
                        res = Math.max(res, Math.abs(area));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}