//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 159 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeBuilder;

/**
 * 剑指 Offer 24.反转链表.fan-zhuan-lian-biao-lcof
 *
 * @author db117
 * @since 2021-01-13 18:01:03
 **/

public class Offer_24 {
    public static void main(String[] args) {
        Solution solution = new Offer_24().new Solution();
        ListNodeBuilder.print(solution.reverseList(ListNodeBuilder.builder(new int[]{
                1, 2, 3, 4, 5
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
        public ListNode reverseList(ListNode head) {
            ListNode cur = head, pre = null, tmp;
            while (cur != null) {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return cur;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            // 虚拟节点
            ListNode v = new ListNode(-1);
            v.next = head;

            ListNode next = head.next;
            // 头节点没有下一级
            head.next = null;
            while (next != null) {
                // 把next插入到一虚拟节点为头的翻转链表
                ListNode tmp = next.next;

                next.next = v.next;
                v.next = next;

                next = tmp;
            }

            return v.next;
        }
    }
}