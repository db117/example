//给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全
//程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds
//[0] 开始，到 rounds[1] 结束。 
//
// 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。 
//
// 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, rounds = [1,3,1,2]
//输出：[1,2]
//解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
//1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
//其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。 
//
// 示例 2： 
//
// 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
//输出：[2]
// 
//
// 示例 3： 
//
// 输入：n = 7, rounds = [1,3,5,7]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= m <= 100 
// rounds.length == m + 1 
// 1 <= rounds[i] <= n 
// rounds[i] != rounds[i + 1] ，其中 0 <= i < m 
// 
// Related Topics 数组 
// 👍 14 👎 0


package com.db117.example.leetcode.solution15;

import java.util.LinkedList;
import java.util.List;

/**
 * 1560.圆形赛道上经过次数最多的扇区.most-visited-sector-in-a-circular-track
 *
 * @author db117
 * @since 2020-12-25 15:50:08
 **/

public class Solution1560 {
    public static void main(String[] args) {
        Solution solution = new Solution1560().new Solution();
        System.out.println(solution.mostVisited(2, new int[]{
                2, 1, 2, 1, 2, 1, 2, 1, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            List<Integer> ans = new LinkedList<>();
            // 中间可以直接去掉,只看开始结束
            int start = rounds[0];
            int end = rounds[rounds.length - 1];

            if (start <= end) {
                // 可以看成只跑了这一段
                for (int i = start; i <= end; i++) {
                    ans.add(i);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    if (i >= start || i <= end) {
                        ans.add(i);
                    }
                }
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public List<Integer> mostVisited(int n, int[] rounds) {
            int max = 0;
            int[] flag = new int[n + 1];

            // 开始位置只在起跑时记录 一次
            flag[rounds[0]]++;

            for (int i = 1; i < rounds.length; i++) {
                if (rounds[i - 1] < rounds[i]) {
                    // 不计开始位置,记录结束位置
                    for (int j = rounds[i - 1] + 1; j <= rounds[i]; j++) {
                        flag[j]++;

                        max = Math.max(max, flag[j]);
                    }
                } else {
                    for (int j = 1; j <= n; j++) {
                        // 不计开始位置,记录结束位置
                        if (j <= rounds[i] || rounds[i - 1] < j) {
                            flag[j]++;

                            max = Math.max(max, flag[j]);
                        }
                    }
                }
            }

            List<Integer> ans = new LinkedList<>();
            for (int i = 1; i < flag.length; i++) {
                if (flag[i] == max) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}