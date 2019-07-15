package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/
@Slf4j
public class Solution77 {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    /**
     * 回溯
     *
     * @param res  然后
     * @param temp 当前
     * @param n    总数
     * @param k    需要个数
     * @param j    当前位置
     */
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int j) {
        if (k == 0) {
            // 结束
            res.add(new ArrayList<>(temp));
            return;
        }

        // 取得数必须大于已经取的数字
        for (int i = j; i <= n; i++) {
            temp.add(i);
            backtrack(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
