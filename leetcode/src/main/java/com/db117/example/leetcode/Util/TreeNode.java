package com.db117.example.leetcode.Util;

import lombok.extern.slf4j.Slf4j;

/**
 * 公用二叉树
 *
 * @author db117
 * @date 2019/7/10
 **/
@Slf4j
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
