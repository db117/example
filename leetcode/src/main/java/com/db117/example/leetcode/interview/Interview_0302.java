


//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 37 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.base.Optimized;

import java.util.Stack;

/**
 * 面试题 03.02.栈的最小值.min-stack-lcci
 *
 * @author db117
 * @since 2021-01-08 15:58:32
 **/
@Optimized
public class Interview_0302 {
    public static void main(String[] args) {
        MinStack minStack = new Interview_0302().new MinStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        // 保存数据
        Stack<Integer> stack = new Stack<>();
        // 保存当前的最小值
        Stack<Integer> minStack = new Stack<>();


        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.empty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.peek()));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}