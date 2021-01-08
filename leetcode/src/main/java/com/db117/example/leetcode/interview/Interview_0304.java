


//实现一个MyQueue类，该类用两个栈来实现一个队列。 示例： MyQueue queue = new MyQueue(); queue.push(1); 
//queue.push(2); queue.peek();  // 返回 1 queue.pop();   // 返回 1 queue.empty(); // 返
//回 false 说明： 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty
// 操作是合法的。 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 假设所有操作都是有效的 
//（例如，一个空的队列不会调用 pop 或者 peek 操作）。 Related Topics 栈 
// 👍 27 👎 0


package com.db117.example.leetcode.interview;

import java.util.Stack;

/**
 * 面试题 03.04.化栈为队.implement-queue-using-stacks-lcci
 *
 * @author db117
 * @since 2021-01-08 16:08:50
 **/

public class Interview_0304 {
    public static void main(String[] args) {
        MyQueue solution = new Interview_0304().new MyQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Stack<Integer> write = new Stack<>();
        Stack<Integer> read = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            write.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            // 确保读队列不为null
            peek();

            return read.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!read.empty()) {
                // 读队列不为null则操作读队列
                return read.peek();
            }
            while (!write.empty()) {
                // 把数据都放入读队列
                read.push(write.pop());
            }

            // 题目不会进行非法操作 直接递归
            return peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return write.empty() && read.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}