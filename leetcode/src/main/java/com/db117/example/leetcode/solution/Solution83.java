package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.util.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/8
 **/

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            // 找到下一个与当前一样的
            while (next != null && cur.val != next.val) {
                cur = next;
                next = cur.next;
            }

            // 循环删除相同的
            while (next != null && cur.val == next.val) {
                cur.next = next.next;
                next = cur.next;
            }
        }
        // head不可能删除
        return head;
    }
}
