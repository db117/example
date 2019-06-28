package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/27
 **/
@Slf4j
public class Solution56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution56().merge(new int[][]{
                new int[]{1, 4}
                , new int[]{1, 10}
                , new int[]{2, 10}
                , new int[]{5, 10}
                , new int[]{2, 3}})));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        // 根据区间开始进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        int index = 0;
        int start = intervals[index][0];
        int end = intervals[index][1];
        while (index < intervals.length) {
            // 结束区间最大值
            end = Math.max(end, intervals[index][1]);

            if (index == intervals.length - 2) {
                // 最后一个了
                if (end < intervals[intervals.length - 1][0]) {
                    // 不连续
                    res.add(new int[]{start, end});
                    res.add(intervals[index + 1]);
                } else {
                    // 连续
                    res.add(new int[]{start, Math.max(end, intervals[index + 1][1])});
                }
                break;
            }

            // 找到不连续的为止
            if (end >= intervals[index + 1][0]) {
                index++;
                continue;
            }
            // 添加区间
            res.add(new int[]{start, end});
            // 重置区间
            start = intervals[++index][0];
            end = 0;
        }
        return res.toArray(new int[0][0]);
    }
}
