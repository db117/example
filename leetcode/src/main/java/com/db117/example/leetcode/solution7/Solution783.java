package com.db117.example.leetcode.solution7;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * @author db117
 * @date 2020/8/17/017 11:27
 **/
public class Solution783 {
    // 最小值
    private int min = Integer.MAX_VALUE;
    // 前置节点
    private TreeNode pre;


    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }


    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);

        if (pre != null) {
            // 求差
            min = Math.min(min, root.val - pre.val);
        }
        // 中序遍历为升序,当前节点为前置节点
        pre = root;

        helper(root.right);

    }
}
