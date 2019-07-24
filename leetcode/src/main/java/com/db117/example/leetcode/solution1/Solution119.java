package com.db117.example.leetcode.solution1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/24/024
 **/
@Slf4j
public class Solution119 {
    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        res[0] = 1;

        // 遍历rowIndex-1次
        for (int i = 1; i <= rowIndex; i++) {
            // 当前行的最后一个为1
            res[i] = 1;

            for (int j = i - 1; j > 0; j--) {
                // 每一行等于上一行当前位置加上上一个位置
                res[j] = res[j] + res[j - 1];
            }
        }
        return Arrays.asList(res);
    }
}
