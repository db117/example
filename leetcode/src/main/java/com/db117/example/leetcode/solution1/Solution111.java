package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/16/016 16:27
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        // 广度优先
        int depth = 1;
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        // 根据点没有字节点的情况
        if (root.left != null) {
            deque.addFirst(root.left);
        }
        if (root.right != null) {
            deque.addFirst(root.right);
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            // 深度增加
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode last = deque.pollLast();

                // 左右子节点都为空则结束
                if (last.right == null && last.left == null) {
                    return depth;
                }
                if (last.left != null) {
                    deque.addFirst(last.left);
                }
                if (last.right != null) {
                    deque.addFirst(last.right);
                }
            }
        }
        return depth;
    }
}
