package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/
@Slf4j
public class Solution84 {
    public static void main(String[] args) {
        System.out.println(new Solution84().largestRectangleArea(new int[]{
                4, 1, 1, 3, 1, 5
        }));
    }

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
