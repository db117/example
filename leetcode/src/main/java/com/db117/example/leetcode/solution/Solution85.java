package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/9
 **/
@Slf4j
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (char[] chars : matrix) {
            // 每一行遍历一次,求高
            // 每一次在上一次的基础上进行修改,+1或置为0
            for (int j = 0; j < heights.length; j++) {
                heights[j] = chars[j] == '1' ? heights[j] + 1 : 0;
            }
            res = Math.max(res, largestRectangleArea(heights));
        }

        return res;
    }

    /**
     * 84题
     *
     * @param heights 每行的高度
     * @return 最大面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = heights[0];

        int i = 0;
        while (i < len) {
            // 当当前数字大于栈顶,入栈
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                Integer pop = stack.pop();
                // 当前弹出的面积=弹出的下标的值*(当前下标-当前弹出的下标)
                // 即以弹出的为高,宽为弹出的下标到当前位置
                max = Math.max(max, heights[pop] * (stack.isEmpty() ? i : (i - 1 - stack.peek())));
            }
        }
        // 剩余的都弹出来
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            // 当栈已经为空时,宽为整个长度
            max = Math.max(max, heights[pop] * (stack.isEmpty() ? len : (len - 1 - stack.peek())));
        }
        return max;
    }
}
