//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 112 👎 0


package com.db117.example.leetcode.solution8;

import java.util.HashSet;
import java.util.Set;

/**
 * 874.模拟行走机器人.walking-robot-simulation
 *
 * @author db117
 * @since 2020-11-09 17:57:16
 **/

public class Solution874 {
    public static void main(String[] args) {
        Solution solution = new Solution874().new Solution();

        // [-2,8,3,7,-1]
        //[[-4,-1],[1,-1],[1,4],[5,0],[4,5],[-2,-1],[2,-5],[5,1],[-3,-1],[5,-3]]
        System.out.println(solution.robotSim(new int[]{
                        -2, 8, 3, 7, -1
                },
                new int[][]{
                        {-4, -1},
                        {1, -1},
                        {1, 4},
                        {5, 0},
                        {4, 5},
                        {-2, -1},
                        {5, 1},
                        {-3, -1},
                        {5, -3},
                        {2, -5},
                }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<Integer> set = new HashSet<>();
            for (int[] obstacle : obstacles) {
                set.add(index(obstacle));
            }
            // 北 东 南 西 -1索引加一  -2索引减一
            int[] xD = new int[]{0, 1, 0, -1};
            int[] yD = new int[]{1, 0, -1, 0};
            // 方向索引
            int index = 0;

            int[] tmp = new int[2];

            int max = 0;
            // 当前位置
            int x = 0, y = 0;
            for (int i : commands) {
                if (i < 0) {
                    // 调整方向
                    if (i == -1) {
                        index++;
                    } else {
                        index--;
                    }

                    // 越界
                    if (index > 3) {
                        index -= 4;
                    }
                    if (index < 0) {
                        index += 4;
                    }
                } else {
                    for (int j = 0; j < i; j++) {
                        // 走起来
                        int xNext = x + xD[index];
                        int yNext = y + yD[index];
                        tmp[0] = xNext;
                        tmp[1] = yNext;

                        if (set.contains(index(tmp))) {
                            // 被挡住了
                            break;
                        }

                        x = xNext;
                        y = yNext;

                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
            return max;
        }

        /**
         * 建立唯一索引
         */
        public Integer index(int[] obstacle) {
            return ((obstacle[0] + 30000) << 16) | (obstacle[1] + 30000);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}