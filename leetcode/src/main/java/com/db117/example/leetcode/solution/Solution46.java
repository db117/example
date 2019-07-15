package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/24
 **/
@Slf4j
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(nums.length), nums, new boolean[nums.length]);
        return res;
    }

    /**
     * 回溯全排列
     *
     * @param res   返回集合
     * @param temp  当前排列
     * @param nums  源数组
     * @param flags 标识数据
     */
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] flags) {
        if (temp.size() >= nums.length) {
            // 结束条件
            res.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                // 标记
                flags[i] = true;
                temp.add(nums[i]);

                // 递归调用
                backtrack(res, temp, nums, flags);
                // 回溯
                flags[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
        // 无返回
    }
}
