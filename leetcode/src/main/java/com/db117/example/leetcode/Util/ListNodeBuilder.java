package com.db117.example.leetcode.Util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author db117
 * @date 2019/7/10
 **/
@Slf4j
public class ListNodeBuilder {
    private ListNodeBuilder() {
    }

    /**
     * 构建链表
     *
     * @param ints 数组
     * @return 链表头
     */
    public static ListNode builder(int[] ints) {
        ListNode last = new ListNode(ints[0]);
        ListNode head = last;
        for (int i = 1; i < ints.length; i++) {
            last.next = new ListNode(ints[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * 打印
     *
     * @param node 链表头
     */
    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
