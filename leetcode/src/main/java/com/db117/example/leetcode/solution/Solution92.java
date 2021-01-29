package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/10
 **/

public class Solution92 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.builder(new int[]{
                1, 2, 3, 4, 5
        });
        System.out.println(new Solution92().reverseBetween(node, 2, 4));
        ListNodeUtil.print(node);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        // 快进到需要换的位置
        ListNode cur = head;
        ListNode pre = null;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode last = null;
        // 下一个节点开始反转,反转后指向最后一个翻转节点
        ListNode start = pre;
        // 反转的第一个节点,反转后指向后面未反转的链表
        ListNode end = cur;
        // 调转方向
        while (n > 0) {
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
            n--;
        }

        // 拼接链表
        if (start == null) {
            // m=1
            head = pre;
        } else {
            start.next = pre;
        }
        end.next = cur;

        return head;
    }

}
