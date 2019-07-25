package com.db117.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/19
 **/

public class Solution40 {
    public static void main(String[] args) {
        System.out.println(new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        // 回溯
        backtrack(res, new LinkedList<>(), target, candidates, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param res        保存结果
     * @param ans        记录已经放入的值
     * @param target     目标
     * @param candidates 源数组
     * @param index      数组下标
     */
    public void backtrack(List<List<Integer>> res, LinkedList<Integer> ans, int target, int[] candidates, int index) {
        if (target < 0) {
            // 不符合
            return;
        }
        if (target == 0) {
            // 找到
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // 目标小于最小值
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                // 去重,有相同的数字时,跳到最后一个数字
                continue;
            }
            // 添加数字
            ans.addLast(candidates[i]);

            // 递归调用
            backtrack(res, ans, target - candidates[i], candidates, i + 1);

            // 删除数字
            ans.removeLast();
        }
    }
}
