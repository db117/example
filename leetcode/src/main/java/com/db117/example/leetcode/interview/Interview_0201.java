


//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 85 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01.移除重复节点.remove-duplicate-node-lcci
 *
 * @author db117
 * @since 2021-01-08 10:51:57
 **/

public class Interview_0201 {
    public static void main(String[] args) {
        Solution solution = new Interview_0201().new Solution();
        ListNodeBuilder.print(solution.removeDuplicateNodes(ListNodeBuilder.builder(new int[]{
                1, 2, 3, 3, 2, 1
        })));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 保存已经有的数据
            Set<Integer> set = new HashSet<>();
            ListNode tmp = new ListNode(Integer.MIN_VALUE);
            // 假头
            tmp.next = head;
            set.add(head.val);

            while (head != null && head.next != null) {
                if (set.contains(head.next.val)) {
                    delNext(head);
                } else {
                    set.add(head.next.val);
                    head = head.next;
                }
            }
            return tmp.next;
        }

        // 删除下一个节点
        void delNext(ListNode head) {
            if (head.next == null) {
                return;
            }
            ListNode next = head.next;
            head.next = next.next;
            next.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tmp = new ListNode(-1);
            // 假头结点
            tmp.next = head;

            while (head != null && head.next != null) {
                ListNode cur = head;
                // 找到所有相同的节点,删除掉
                while (cur.next != null) {
                    if (cur.next.val == head.val) {
                        // 找到了删除
                        delNext(cur);
                    } else {
                        // 没有找到继续找
                        cur = cur.next;
                    }
                }

                head = head.next;
            }

            return tmp.next;
        }

        // 删除下一个节点
        void delNext(ListNode head) {
            if (head.next == null) {
                return;
            }
            ListNode next = head.next;
            head.next = next.next;
            next.next = null;
        }
    }
}