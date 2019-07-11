package com.db117.example.leetcode.com.db117.example.Util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author db117
 * @date 2019/7/11
 **/
@Slf4j
public class TreeNodeUtil {
    private TreeNodeUtil() {
    }

    /**
     * 打印二叉树
     *
     * @param treeNode 二叉树
     */
    public static void print(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        print(treeNode.left);
        print(treeNode.right);
    }
}
