package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.Util.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/12
 **/

public class Solution25 {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode[] listNodes = new ListNode[]{
                new ListNode(1)
                , new ListNode(2)
                , new ListNode(3)
                , new ListNode(4)
                , new ListNode(5)
        };
        for (int i = 0; i < listNodes.length; i++) {
            if (i + 1 < listNodes.length) {
                listNodes[i].next = listNodes[i + 1];
            }
        }
        ListNode listNode = solution25.reverseKGroup(listNodes[0], 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 结束条件
        if (head == null || k == 1) {
            return head;
        }
        // 判断是否需要翻转
        int count = 1;
        ListNode next = head.next;
        while (next != null && count < k) {
            next = next.next;
            count++;
        }
        if (count != k) {
            return head;
        }

        // 把链表保存到数组中
        ListNode[] listNodes = new ListNode[k];
        while (count > 0) {
            listNodes[count - 1] = head;
            head = head.next;
            count--;
        }

        // 设置next
        for (int i = 0; i < listNodes.length - 1; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        // 设置最后一个为已经拍好序的链表
        listNodes[listNodes.length - 1].next = reverseKGroup(next, k);
        // 返回第一个
        return listNodes[0];
    }

}
