package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * <p>
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * -------------- 5
 * ------------ /-- \
 * ------------2---- 13
 * <p>
 * 输出: 转换为累加树:
 * --------------18
 * ------------ /-- \
 * ---------- 20---- 13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/8/13/013 15:51
 **/
public class Solution538 {
    public static void main(String[] args) {
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                5, 2, 13
        });

        TreeNodeUtil.inorderPrint(new Solution538().convertBST(node));
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        helper(0, root);
        return root;
    }

    private int helper(int sum, TreeNode root) {
        int res = sum;
        // 先算左子树
        if (root.right != null) {
            res = helper(res, root.right);
        }
        // 累加
        res = root.val + res;
        root.val = res;


        if (root.left != null) {
            res = helper(res, root.left);
        }
        return res;
    }
}
