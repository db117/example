//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 84 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 剑指 Offer 55 - I.二叉树的深度.er-cha-shu-de-shen-du-lcof
 *
 * @author db117
 * @since 2021-01-14 14:39:08
 **/

public class Offer_55_I {
    public static void main(String[] args) {
        Solution solution = new Offer_55_I().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int maxDepth = 0;

        public int maxDepth(TreeNode root) {
            helper(root, 1);
            return maxDepth;
        }

        void helper(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            maxDepth = Math.max(maxDepth, depth);
            helper(root.left, depth + 1);
            helper(root.right, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}