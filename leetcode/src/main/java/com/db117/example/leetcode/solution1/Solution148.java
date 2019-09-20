package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeBuilder;

/**
 * 148. 排序链表148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/2/002 16:57
 */
public class Solution148 {
    public static void main(String[] args) {
        ListNodeBuilder.print(new Solution148().sortList(ListNodeBuilder.builder(new int[]{

        })));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cut = cut(head);

        return marge(sortList(head), sortList(cut));
    }

    // 分割链表
    public ListNode cut(ListNode head) {
        ListNode left = head, right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        // 断链
        ListNode temp = left.next;
        left.next = null;
        return temp;
    }

    // 合并两个链表
    public ListNode marge(ListNode left, ListNode right) {
        // 空头
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        // 指向小的
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // 剩余的
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return head.next;
    }
}
