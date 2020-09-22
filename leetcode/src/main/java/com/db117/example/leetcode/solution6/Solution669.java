//给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，
// 使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以
//结果应当返回修剪好的二叉搜索树的新的根节点。 
//
// 示例 1: 
//
// 
//输入: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//输出: 
//    1
//      \
//       2
// 
//
// 示例 2: 
//
// 
//输入: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//输出: 
//      3
//     / 
//   2   
//  /
// 1
// 
// Related Topics 树 
// 👍 274 👎 0


package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 669.修剪二叉搜索树
 *
 * @author db117
 * @date 2020-09-22 14:29:07
 **/
public class Solution669 {
    public static void main(String[] args) {
        Solution solution = new Solution669().new Solution();
        TreeNode build = TreeNodeUtil.build(new Integer[]{
                8, 5, 15, 4, 6, 9, 20
        });

        TreeNodeUtil.inorderPrint(solution.trimBST(build, 7, 9));
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return root;
            }
            if (root.val > high) {
                // 删除自己,以及自己的右节点
                return trimBST(root.left, low, high);
            }
            if (root.val < low) {
                // 删除自己,以及自己的左节点
                return trimBST(root.right, low, high);
            }
            // 修剪左节点
            root.left = trimBST(root.left, low, high);
            // 修剪右节点
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}