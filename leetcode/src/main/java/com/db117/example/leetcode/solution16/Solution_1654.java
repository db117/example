// 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
//
// 跳蚤跳跃的规则如下： 
//
// 
// 它可以 往前 跳恰好 a 个位置（即往右跳）。 
// 它可以 往后 跳恰好 b 个位置（即往左跳）。 
// 它不能 连续 往后跳 2 次。 
// 它不能跳到任何 forbidden 数组中的位置。 
// 
//
// 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。 
//
// 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃
//次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
//输出：3
//解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
// 
//
// 示例 2： 
//
// 
//输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
//输出：2
//解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= forbidden.length <= 1000 
// 1 <= a, b, forbidden[i] <= 2000 
// 0 <= x <= 2000 
// forbidden 中所有位置互不相同。 
// 位置 x 不在 forbidden 中。 
// 
// Related Topics 广度优先搜索 动态规划 
// 👍 16 👎 0


package com.db117.example.leetcode.solution16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1654.到家的最少跳跃次数.minimum-jumps-to-reach-home
 *
 * @author db117
 * @since 2021-02-19 17:34:20
 **/

public class Solution_1654 {
    public static void main(String[] args) {
        Solution solution = new Solution_1654().new Solution();
        System.out.println(solution.minimumJumps(new int[]{
                14, 4, 18, 1, 15
        }, 3, 15, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            // 不能到的位置
            // 已经去过的位置
            Set<Integer> set = Arrays.stream(forbidden)
                    .boxed()
                    .collect(Collectors.toSet());

            // 走的步数
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            // 从0开始走
            queue.offer(0);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    int n = Math.abs(poll);
                    if (n == x) {
                        // 找到了
                        return count;
                    }
                    if (poll > 6001) {
                        // 右边不能过界
                        continue;
                    }
                    // 已经去过了,或不让去
                    if (set.contains(n)) {
                        continue;
                    }
                    // 后退一步
                    int left = n - b;
                    if (left > 0 && poll > 0) {
                        // 上一步不是后退,并且不是负数
                        // 后退标记负数
                        queue.offer(-left);
                    }
                    // 前进一步
                    queue.offer(n + a);

                    // 标记走过了
                    set.add(n);
                }
                count++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}