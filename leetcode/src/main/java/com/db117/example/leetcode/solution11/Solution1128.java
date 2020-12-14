//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 40 👎 0


package com.db117.example.leetcode.solution11;

import java.util.HashMap;
import java.util.Map;

/**
 * 1128.等价多米诺骨牌对的数量.number-of-equivalent-domino-pairs
 *
 * @author db117
 * @since 2020-12-14 11:34:45
 **/

public class Solution1128 {
    public static void main(String[] args) {
        Solution solution = new Solution1128().new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][]{
                {1, 2},
                {2, 1},
                {1, 2},
                {3, 2},
                {3, 2},
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<String, Integer> map = new HashMap<>();

            for (int[] dominoe : dominoes) {
                // 标准化
                int max = Math.max(dominoe[0], dominoe[1]);
                int min = Math.min(dominoe[0], dominoe[1]);

                String key = min + "_" + max;
                // 记录出现的次数
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int res = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer num = entry.getValue();
                if (num > 1) {
                    // 多次出现则为一对
                    res += (num * (num - 1)) / 2;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}