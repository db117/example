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
     * 前序打印二叉树
     *
     * @param treeNode 二叉树
     */
    public static void beforePrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        beforePrint(treeNode.left);
        beforePrint(treeNode.right);
    }

    /**
     * 中序遍历
     */
    public static void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.println(root.val);
        inorderPrint(root.right);
    }

    /**
     * 后序遍历打印
     */
    public static void postOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.val);
    }
}
