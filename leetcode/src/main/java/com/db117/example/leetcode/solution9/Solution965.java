package com.db117.example.leetcode.solution9;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/27/027 11:47
 */
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, root.val);
    }

    public boolean helper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && helper(root.left, val) && helper(root.right, val);
    }
}
