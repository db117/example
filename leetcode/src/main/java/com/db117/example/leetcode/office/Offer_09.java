


//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 157 👎 0


package com.db117.example.leetcode.office;

import java.util.Stack;

/**
 * 剑指 Offer 09.用两个栈实现队列.yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * @author db117
 * @since 2021-01-11 19:01:04
 **/

public class Offer_09 {
    public static void main(String[] args) {
        CQueue solution = new Offer_09().new CQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        Stack<Integer> tail = new Stack<>();
        Stack<Integer> head = new Stack<>();


        public CQueue() {

        }

        public void appendTail(int value) {
            // 直接加
            tail.push(value);
        }

        public int deleteHead() {
            if (head.empty() && tail.empty()) {
                // 没有数据
                return -1;
            }

            if (head.empty()) {
                while (!tail.empty()) {
                    // 当head中没有数据则转移全部数据到head中
                    head.push(tail.pop());
                }
            }

            return head.pop();
        }

    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}