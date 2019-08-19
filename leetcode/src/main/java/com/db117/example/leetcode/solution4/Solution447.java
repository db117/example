package com.db117.example.leetcode.solution4;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/19/019
 */
public class Solution447 {
    public static void main(String[] args) {
        // [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        System.out.println(new Solution447().numberOfBoomerangs(new int[][]{
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{0, -1}
        }));
    }

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        // 缓存相同距离的个数
        Map<Double, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            map.clear();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    // 去掉自己
                    continue;
                }
                // 距离
                double distance = (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                // 相同距离的个数
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            // 相同距离的个数大于1 才会组成回旋镖
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value > 1) {
                    // 相同的距离的个数的回旋镖
                    // n*(n-1)
                    res += (value * (value - 1));
                }
            }

        }
        return res;
    }
}
