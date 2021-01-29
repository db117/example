//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 501 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 143.重排链表.reorder-list
 *
 * @author db117
 * @since 2021-01-28 11:24:06
 **/

public class Solution_143 {
    public static void main(String[] args) {
        Solution solution = new Solution_143().new Solution();
        ListNode builder = ListNodeUtil.builder(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8
        });
        solution.reorderList(builder);
        ListNodeUtil.print(builder);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            // 快慢指针找到中间节点
            ListNode low = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
            // 从中间节点开始反转链表
            ListNode lastHead = reverse(low);
            // 拼接两个链表
            merge(head, lastHead);
        }

        ListNode reverse(ListNode head) {
            ListNode pre = head, cur = head.next, last;
            pre.next = null;
            while (cur != null) {
                last = cur.next;
                cur.next = pre;
                pre = cur;
                cur = last;
            }
            return pre;
        }

        void merge(ListNode left, ListNode right) {
            ListNode cur = new ListNode(-1);

            boolean flag = true;
            while (left != null && right != null) {
                if (flag) {
                    cur.next = left;
                    cur = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    cur = right;
                    right = right.next;
                }
                flag = !flag;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}