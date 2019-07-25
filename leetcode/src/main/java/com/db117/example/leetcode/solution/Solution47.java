package com.db117.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/24
 **/

public class Solution47 {
    public static void main(String[] args) {
        System.out.println(new Solution47().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(nums.length), nums, new boolean[nums.length]);
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] flags) {
        // 结束
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                if (i > 0 && !flags[i - 1] && nums[i] == nums[i - 1]) {
                    // 过虑掉已近处理过的相同数字
                    continue;
                }
                flags[i] = true;
                temp.add(nums[i]);

                backtrack(res, temp, nums, flags);
                // 回溯
                flags[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

}
