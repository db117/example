package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/28
 **/
@Slf4j
public class Solution57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution57().insert(new int[][]{
                        new int[]{1, 2}
                        , new int[]{3, 5}
                        , new int[]{6, 7}
                        , new int[]{8, 10}
                        , new int[]{12, 16}
                }
                , new int[]{
                        4, 8
                })));
    }

    // todo 待优化
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();

        int start = newInterval[0], end = newInterval[1];
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // 比目标区间小
                res.add(interval);
                continue;
            }
            if (interval[0] > newInterval[1]) {
                // 比目标区间大
                res.add(interval);
                continue;
            }
            // 合并区间
            start = Math.min(start, interval[0]);
            end = Math.max(end, interval[1]);
        }
        // 有合并的区间
        if (start != -1 && end != -1) {
            res.add(new int[]{start, end});
        }
        int[][] ints = res.toArray(new int[0][0]);
        Arrays.sort(ints, Comparator.comparingInt(o -> o[0]));
        return ints;
    }
}
