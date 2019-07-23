package com.db117.example.leetcode.solution1;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/23/023
 **/
@Slf4j
public class Solution155 {

    public class MinStack {
        Stack<Integer> stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            // 放入数据,在放入当前最小值
            if (stack.isEmpty()) {
                stack.push(x);
                stack.push(x);
            } else {
                // 获取最小值
                Integer min = Math.min(stack.peek(), x);
                stack.push(x);
                stack.push(min);
            }
        }

        public void pop() {
            // 弹出两个
            stack.pop();
            stack.pop();
        }

        public int top() {
            // 先弹出最小值
            Integer min = stack.pop();
            Integer value = stack.peek();
            stack.push(min);
            return value;
        }

        public int getMin() {
            return stack.peek();
        }

    }
}
