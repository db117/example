package com.db117.example.leetcode.Util;

import lombok.extern.slf4j.Slf4j;

/**
 * 通用节点
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
