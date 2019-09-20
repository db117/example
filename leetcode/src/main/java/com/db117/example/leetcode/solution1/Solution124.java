package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * -1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/8/008 14:55
 */
public class Solution124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树的最大值,小于0则边链接
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        // 包含当前节点的最大值,即不走当前节点的父节点
        // 在计算每一个节点时都计算一次,即为结果
        max = Math.max(max, root.val + right + left);

        // 走当前节点的父节点,则只能在左右节点中选择一个最大的
        return root.val + Math.max(left, right);
    }
}
