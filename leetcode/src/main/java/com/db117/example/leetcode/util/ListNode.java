package com.db117.example.leetcode.util;

/**
 * 公用链表
 *
 * @author db117
 * @date 2019/7/10
 **/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
