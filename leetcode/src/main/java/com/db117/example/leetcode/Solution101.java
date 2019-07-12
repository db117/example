package com.db117.example.leetcode;

import com.db117.example.leetcode.com.db117.example.Util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // 都为空
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // 判断当前是否相等,左节点的左节点和右节点的右节点是否相等
        // 左节点的右节点和有节点的左节点是否相等
        return (left.val == right.val)
                && helper(left.left, right.right)
                && helper(left.right, right.left);
    }
}
