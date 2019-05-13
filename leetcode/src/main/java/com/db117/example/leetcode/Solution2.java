package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author db117
 * @date 2019/5/10
 **/
@Slf4j
public class Solution2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        Solution2 solution = new Solution2();
        ListNode node = solution.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        // 返回
        ListNode res = out;
        ListNode left = l1, right = l2;

        // 最后一个数
        ListNode last = null;

        while (left != null || right != null) {
            int sum = (left == null ? 0 : left.val) +
                    (right == null ? 0 : right.val) + out.val;
            out.val = sum % 10;
            out.next = new ListNode(sum / 10);

            last = out;
            out = out.next;
            left = left == null ? null : left.next;
            right = right == null ? null : right.next;
        }
        // 当最后一个为0时删除
        if (out.val == 0) {
            last.next = null;
        }

        return res;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
