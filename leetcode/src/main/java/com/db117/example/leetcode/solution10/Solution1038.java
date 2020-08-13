package com.db117.example.leetcode.solution10;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 1038. 从二叉搜索树到更大和树
 * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于0 和100之间。
 * 给定的树为二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/8/13/013 16:34
 **/
public class Solution1038 {
    public TreeNode bstToGst(TreeNode root) {
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
