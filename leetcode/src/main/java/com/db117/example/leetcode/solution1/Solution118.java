package com.db117.example.leetcode.solution1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/23/023
 **/
@Slf4j
public class Solution118 {

    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        // 第一行
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        res.add(row);

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                int temp = 0;
                // 加上上一行当前位置
                if (j < i) {
                    temp += res.get(i - 1).get(j);
                }
                // 加上上一行上一个位置
                if (j > 0) {
                    temp += res.get(i - 1).get(j - 1);
                }
                row.add(temp);
            }
            res.add(row);
        }
        return res;
    }
}
