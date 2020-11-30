//在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。 
//
// 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足 i < j 且有 (time[i] + tim
//e[j]) % 60 == 0。 
//
// 
//
// 示例 1： 
//
// 输入：[30,20,150,100,40]
//输出：3
//解释：这三对的总持续时间可被 60 整数：
//(time[0] = 30, time[2] = 150): 总持续时间 180
//(time[1] = 20, time[3] = 100): 总持续时间 120
//(time[1] = 20, time[4] = 40): 总持续时间 60
// 
//
// 示例 2： 
//
// 输入：[60,60,60]
//输出：3
//解释：所有三对的总持续时间都是 120，可以被 60 整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= time.length <= 60000 
// 1 <= time[i] <= 500 
// 
// Related Topics 数组 
// 👍 114 👎 0


package com.db117.example.leetcode.solution10;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010.总持续时间可被 60 整除的歌曲.pairs-of-songs-with-total-durations-divisible-by-60
 *
 * @author db117
 * @since 2020-11-30 11:28:54
 **/

public class Solution1010 {
    public static void main(String[] args) {
        Solution solution = new Solution1010().new Solution();
        System.out.println(solution.numPairsDivisibleBy60(new int[]{
                60, 60, 60
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            // 使用map保存每一个数字出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int j : time) {
                int n = j % 60;
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            int res = 0;
            for (int i : time) {
                // 找到能凑够60的数字个数
                int n = 60 - (i % 60);
                if (n == 60) {
                    n = 0;
                }
                res += map.getOrDefault(n, 0);

                if (n == 30 || n == 0) {
                    // 减去自己
                    res--;
                }
            }

            // 去掉相互的
            return res / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}