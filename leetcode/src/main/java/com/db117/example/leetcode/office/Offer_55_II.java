//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 103 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 剑指 Offer 55 - II.平衡二叉树.ping-heng-er-cha-shu-lcof
 *
 * @author db117
 * @since 2021-01-18 16:53:43
 **/

public class Offer_55_II {
    public static void main(String[] args) {
        Solution solution = new Offer_55_II().new Solution();
        System.out.println(solution.isBalanced(TreeNodeUtil.build(new Integer[]{
                3, 9, 20, null, null, 15, 7
        })));
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
        boolean ans = true;

        public boolean isBalanced(TreeNode root) {
            helper(root);
            return ans;
        }

        int helper(TreeNode root) {
            if (!ans || root == null) {
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);
            // 深度超过1
            if (Math.abs(left - right) > 1) {
                ans = false;
            }

            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}