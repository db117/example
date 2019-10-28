package com.db117.example.leetcode.solution4;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/28/028 14:36
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 是左子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        // 遍历所有节点
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
