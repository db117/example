package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @since 2020/3/11 14:59
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 把t2往t1合
        if (t1 == null) {
            return t2;
        }
        helper(t1, t2);
        return t1;
    }

    public void helper(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return;
        }
        // 合并
        t1.val += t2.val;

        if (t1.left != null) {
            // 合并左子节点
            helper(t1.left, t2.left);
        } else if (t2.left != null) {
            // 1左子节点为空,2不为空直接使用2的左子节点
            t1.left = t2.left;
        }

        if (t1.right != null) {
            helper(t1.right, t2.right);
        } else if (t2.right != null) {
            t1.right = t2.right;
        }
    }
}
