//回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。 
//
// 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= points[i][j] <= 100 
// 
// Related Topics 数学 
// 👍 22 👎 0


package com.db117.example.leetcode.solution10;

/**
 * 1037.有效的回旋镖.valid-boomerang
 *
 * @author db117
 * @since 2020-12-11 17:25:28
 **/

public class Solution1037 {
    public static void main(String[] args) {
        Solution solution = new Solution1037().new Solution();
        System.out.println(solution.isBoomerang(new int[][]{
                {1, 1},
                {2, 3},
                {3, 2},
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBoomerang(int[][] points) {
            // 前两个点的差值和后两个点的差值的比例一样则在一条直线上
            int oneX = points[1][0] - points[0][0];
            int oneY = points[1][1] - points[0][1];

            int twoX = points[2][0] - points[1][0];
            int twoY = points[2][1] - points[1][1];


            return oneX * twoY != oneY * twoX;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}