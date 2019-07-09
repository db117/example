package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/9
 **/
@Slf4j
public class Solution86 {
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

        ListNode listNode = new Solution86().partition(head, 0);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
