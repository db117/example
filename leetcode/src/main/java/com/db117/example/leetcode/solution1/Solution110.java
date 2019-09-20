package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/16/016
 */
public class Solution110 {
    // 是否是平衡二叉树
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!flag) {
            // 已经确定不上平衡二叉树了
            return 0;
        }
        // 左边的高度
        int left = helper(root.left) + 1;
        // 右边的高度
        int right = helper(root.right) + 1;
        // 差值大于1则不是
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        // 返回最大高度
        return Math.max(left, right);
    }
}
