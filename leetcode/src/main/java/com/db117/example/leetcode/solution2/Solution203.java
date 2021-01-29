package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author db117
 * @date 2019/8/8/008
 **/
public class Solution203 {
    public static void main(String[] args) {
        ListNode builder = ListNodeUtil.builder(new int[]{1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 7, 8, 9});
        ListNodeUtil.print(new Solution203().removeElements(builder, 1));
    }

    public ListNode removeElements(ListNode head, int val) {
        // 先删头结点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode pre = head, cur = head.next, next;

        while (cur != null) {
            if (cur.val == val) {
                // 删除
                next = cur.next;
                pre.next = next;

                // 修改变量
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
