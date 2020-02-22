package com.db117.example.leetcode.solution13;

import java.util.*;

/**
 * 1337. 方阵中战斗力最弱的 K 行
 * <p>
 * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
 * <p>
 * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * @author db117
 * @since 2020/2/22 18:38
 */
public class Solution1337 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(new int[][]{
                {1, 0},
                {1, 0},
                {1, 0},
                {1, 1},
        }, 4)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        // 战斗力->行号
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            int num = 0;
            for (int j : mat[i]) {
                if (j == 1) {
                    num++;
                } else {
                    break;
                }
            }
            List<Integer> list = treeMap.getOrDefault(num, new ArrayList<>());
            list.add(i);
            treeMap.put(num, list);
        }

        int index = 0;
        int size = treeMap.size();
        for (int i = 0; i < size && index < k; i++) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.firstEntry();
            treeMap.remove(entry.getKey());
            List<Integer> value = entry.getValue();
            // 按行号排序
            value.sort(Comparator.comparingInt(o -> o));

            for (Integer integer : value) {
                if (index < k) {
                    ans[index++] = integer;
                } else {
                    break;
                }
            }
        }


        return ans;
    }

}
