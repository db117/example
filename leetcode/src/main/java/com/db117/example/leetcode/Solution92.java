package com.db117.example.leetcode;

import com.db117.example.leetcode.com.db117.example.Util.ListNode;
import com.db117.example.leetcode.com.db117.example.Util.ListNodeBuilder;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class Solution92 {
    public static void main(String[] args) {
        ListNode node = ListNodeBuilder.builder(new int[]{
                1, 2, 3, 4, 5
        });
        System.out.println(new Solution92().reverseBetween(node, 1, 1));
        ListNodeBuilder.print(node);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
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
        // 下一个节点开始反转
        ListNode start = pre;
        ListNode end = cur;
        // 调转方向
        while (n > 1) {
            last = cur.next;
            cur.next = pre;
            cur = last;
            pre = cur;
            n--;
        }

        // 拼接链表
        if (start == null) {
            head = pre;
        } else {
            start.next = pre;
        }
        end.next = cur;

        return head;
    }

}
