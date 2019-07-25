package com.db117.example.leetcode.solution;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/9
 **/

public class Solution90 {
    public static void main(String[] args) {
        System.out.println(new Solution90().subsetsWithDup(new int[]{
                1, 1, 2, 2
        }));
    }

    @Benchmark
    @Fork(1)
    public void measureName() {
        new Solution90().subsetsWithDup(new int[]{
                1, 2, 2
        });
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);

        res.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            // 统计有多少个重复的
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            int size = res.size();
            // 把每一个拉出来,加上当前的
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new LinkedList<>(res.get(j));
                // 再前面生成的集合后面依次加上重复的数字
                // (1,2,2)加一个2,加2个2
                for (int k = 0; k <= count; k++) {
                    temp.add(nums[i]);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }
}
