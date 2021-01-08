


//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计 
// 👍 21 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 03.01.三合一.three-in-one-lcci
 *
 * @author db117
 * @since 2021-01-08 16:23:06
 **/

public class Interview_0301 {
    public static void main(String[] args) {
        TripleInOne solution = new Interview_0301().new TripleInOne(18);
        //["TripleInOne", "peek", "pop", "isEmpty", "push", "pop", "push", "push", "pop", "push", "push", "isEmpty", "pop", "peek", "push", "peek", "isEmpty", "peek", "pop", "push", "isEmpty", "pop", "peek", "peek", "pop", "peek", "isEmpty", "pop", "push", "isEmpty", "peek", "push", "peek", "isEmpty", "isEmpty", "isEmpty", "isEmpty", "peek", "push", "push", "peek", "isEmpty", "peek", "isEmpty", "push", "push", "push", "peek", "peek", "pop", "push", "push", "isEmpty", "peek", "pop", "push", "peek", "peek", "pop", "isEmpty", "pop", "peek", "peek", "push", "push"]
        //[[18], [1], [2], [1], [2, 40], [2], [0, 44], [1, 40], [0], [1, 54], [0, 42], [0], [1], [1], [0, 56], [2], [0], [2], [2], [1, 15], [1], [1], [0], [2], [0], [0], [1], [0], [0, 32], [0], [0], [0, 30], [2], [1], [1], [0], [0], [0], [0, 56], [1, 40], [2], [0], [0], [0], [2, 11], [0, 16], [0, 3], [2], [0], [2], [0, 39], [0, 63], [1], [2], [0], [2, 36], [1], [0], [2], [1], [0], [1], [2], [0, 8], [0, 38]]

        System.out.println(solution.peek(1));
        System.out.println(solution.pop(2));
        System.out.println(solution.isEmpty(1));
        solution.push(2, 40);
        System.out.println(solution.pop(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {
        // 保存数据
        // 索引位置为 (0 1 2) +(i*3)
        int[] table;
        // 记录下一个插入的位置
        // 循环使用
        int[] indexs = new int[3];
        // 记录大小
        int[] size = new int[3];

        int stackSize;

        public TripleInOne(int stackSize) {
            table = new int[stackSize * 3];
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            // 是否已经满了
            if (size[stackNum] == stackSize) {
                return;
            }
            // 计算插入的位置
            int index = stackNum + indexs[stackNum] * 3;
            index = index % table.length;


            table[index] = value;
            indexs[stackNum]++;
            size[stackNum]++;
        }

        public int pop(int stackNum) {
            int peek = peek(stackNum);

            if (peek != -1) {
                // 调整栈大小
                size[stackNum]--;
                indexs[stackNum]--;
            }

            return peek;

        }

        public int peek(int stackNum) {
            if (size[stackNum] == 0) {
                return -1;
            }
            // 计算pop的位置
            int index = indexs[stackNum] - 1;
            index *= 3;
            index += stackNum;
            if (index < 0) {
                index += table.length;
            }
            index %= table.length;

            return table[index];
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}