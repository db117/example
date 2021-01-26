

//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 695 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 114.二叉树展开为链表.flatten-binary-tree-to-linked-list
 *
 * @author db117
 * @since 2021-01-26 16:22:36
 **/

public class Solution_114 {
    public static void main(String[] args) {
        Solution solution = new Solution_114().new Solution();
        TreeNode treeNode = TreeNodeUtil.build(new Integer[]{
                1, 2, 5, 3, 4, null, 6
        });
        solution.flatten(treeNode);
        TreeNodeUtil.inorderPrint(treeNode);

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
        // 最后一个节点
        TreeNode last;

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            // 后序
            flatten(root.right);
            flatten(root.left);


            root.right = last;
            root.left = null;

            last = root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}