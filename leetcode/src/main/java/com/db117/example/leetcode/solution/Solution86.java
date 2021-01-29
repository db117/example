package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

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

public class Solution86 {
    public static void main(String[] args) {
        int[] data = new int[]{
                1
        };
        ListNode head = ListNodeUtil.builder(data);

        ListNode listNode = new Solution86().partition(head, 2);

        ListNodeUtil.print(listNode);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 用两个链表进行保存
        ListNode less = null, big = null;
        // 虚拟的头结点,指向需要返回的节点
        ListNode lessBefore = new ListNode(-1);
        ListNode bigBefore = new ListNode(-1);
        while (head != null) {
            // 比目标小的节点
            if (head.val < x) {
                if (lessBefore.next == null) {
                    // 找到第一个小链表头
                    less = head;
                    lessBefore.next = less;
                } else {
                    less.next = head;
                    less = less.next;
                }
            } else {
                // 比目标节点大的节点
                if (bigBefore.next == null) {
                    // 找到第一个大链表头
                    big = head;
                    bigBefore.next = head;
                } else {
                    big.next = head;
                    big = big.next;
                }
            }
            head = head.next;
        }
        // 没有小节点的话
        if (lessBefore.next == null) {
            return bigBefore.next;
        }
        // 拼接链表
        less.next = bigBefore.next;
        if (big != null) {
            big.next = null;
        }
        return lessBefore.next;
    }
}
