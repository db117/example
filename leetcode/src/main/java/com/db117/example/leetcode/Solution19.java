package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/10
 **/
@Slf4j
public class Solution19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        // 右指针右移n位
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            // n等于链表长度
            head = head.next;
            return head;
        }

        // 把左右指针同时往右移,直到结束
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        // 删除左节点的下一个节点
        left.next = left.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
