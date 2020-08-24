//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 342 👎 0


package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 572.另一个树的子树
 *
 * @author db117
 * @date 2020-08-23 18:43:11
 **/
public class Solution572 {
    public static void main(String[] args) {
        Solution solution = new Solution572().new Solution();
        TreeNode s = TreeNodeUtil.build(new Integer[]{
                3, 4, 5, 1, 2, null, null, 0

        });
        TreeNode t = TreeNodeUtil.build(new Integer[]{
                4, 1, 2
        });

        System.out.println(solution.isSubtree(s, t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (t == s) {
                // 都为null
                return true;
            }

            if (s == null || t == null) {
                // 有一个为null
                return false;
            }

            // 递归判断所有节点
            return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        // 以当前根节点为基础s是否包含t,即s的子节点包含t
        boolean helper(TreeNode s, TreeNode t) {
            if (t == s) {
                // 都为null
                return true;
            }

            if (s == null || t == null) {
                // 有一个为null
                return false;
            }

            // 判断当前节点和子节点是否相等
            return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}