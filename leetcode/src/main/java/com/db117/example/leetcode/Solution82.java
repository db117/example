package com.db117.example.leetcode;

import com.db117.example.leetcode.com.db117.example.Util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/
@Slf4j
public class Solution82 {
    public static void main(String[] args) {
        int[] data = new int[]{
                1, 1
        };
        ListNode last = new ListNode(data[0]);
        ListNode head = last;
        for (int i = 1; i < data.length; i++) {
            last.next = new ListNode(data[i]);
            last = last.next;
        }

        ListNode listNode = new Solution82().deleteDuplicates(head);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 创建已经虚拟的节点,使其下一个为要返回的头结点
        ListNode first = new ListNode(Integer.MIN_VALUE);
        first.next = head;
        // 慢节点的前置节点
        ListNode pre = first;
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // 不重复,则一直循环到重复为止
            while (fast.next != null && slow.val != fast.next.val) {
                // 指针后移
                pre = slow;
                slow = slow.next;
                fast = slow;
            }
            // 重复,则一直到不重复为止
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // 删除重复,即把前置节点的next指向快节点
            if (slow != fast) {
                pre.next = fast.next;
                slow = pre.next;
                fast = slow;
            }
        }
        return first.next;
    }

}
