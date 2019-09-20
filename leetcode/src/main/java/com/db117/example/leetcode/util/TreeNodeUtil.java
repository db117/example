package com.db117.example.leetcode.util;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author db117
 * @date 2019/7/11
 **/

public class TreeNodeUtil {
    private TreeNodeUtil() {
    }

    /**
     * 构建二叉树
     *
     * @param data 数组
     */
    public static TreeNode build(Integer[] data) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        TreeNode root = new TreeNode(data[0]);
        deque.offerFirst(root);

        int index = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = deque.pollFirst();

                // 构建左节点
                first.left = data[index] == null ? null : new TreeNode(data[index]);
                index++;
                if (index >= data.length) {
                    return root;
                }
                // 加入到栈
                if (first.left != null) {
                    deque.offerLast(first.left);
                }

                // 构建右节点
                first.right = data[index] == null ? null : new TreeNode(data[index]);
                index++;
                if (index >= data.length) {
                    return root;
                }
                // 加入到栈
                if (first.right != null) {
                    deque.offerLast(first.right);
                }
            }
        }
        return root;
    }

    /**
     * 前序打印二叉树
     *
     * @param treeNode 二叉树
     */
    public static void preorderPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preorderPrint(treeNode.left);
        preorderPrint(treeNode.right);
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
