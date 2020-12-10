//三枚石子放置在数轴上，位置分别为 a，b，c。 
//
// 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位
//置 k 处，其中 x < k < z 且 k != y。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximu
//m_moves] 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 2, c = 5
//输出：[1, 2]
//解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
// 
//
// 示例 2：
//
// 输入：a = 4, b = 3, c = 2
//输出：[0, 0]
//解释：我们无法进行任何移动。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 100 
// 1 <= b <= 100 
// 1 <= c <= 100 
// a != b, b != c, c != a 
// 
// Related Topics 脑筋急转弯 
// 👍 27 👎 0


package com.db117.example.leetcode.solution10;

import java.util.Arrays;

/**
 * 1033.移动石子直到连续.moving-stones-until-consecutive
 *
 * @author db117
 * @since 2020-12-10 18:39:50
 **/

public class Solution1033 {
    public static void main(String[] args) {
        Solution solution = new Solution1033().new Solution();
        System.out.println(Arrays.toString(solution.numMovesStones(1, 3, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] res = new int[2];

            // 排序找到最大最小值
            int[] sort = new int[]{a, b, c};

            Arrays.sort(sort);

            // 追多就是每一次移动一个位置
            res[1] = sort[2] - sort[0] - 2;

            if ((sort[1] - sort[0] == 2) || (sort[2] - sort[1] == 2)) {
                res[0] = 1;

                return res;
            }

            // 如果不连续则最少移动一次
            if (sort[1] - sort[0] > 1) {
                res[0]++;
            }
            if (sort[2] - sort[1] > 1) {
                res[0]++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}