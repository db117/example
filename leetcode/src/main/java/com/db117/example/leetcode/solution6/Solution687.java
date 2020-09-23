//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
// 这条路径可以经过也可以不经过根节点。
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 357 👎 0


package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 687.最长同值路径
 *
 * @author db117
 * @date 2020-09-23 11:33:47
 **/
public class Solution687 {
    public static void main(String[] args) {
        Solution solution = new Solution687().new Solution();
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1, null, 1, 1, 1, 1, 1, 1
//                1, 4, 5, 4, 4, null, 5
        });
        System.out.println(solution.longestUnivaluePath(node));
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
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            help(root);
            return max;
        }

        private void help(TreeNode root) {
            if (root == null) {
                return;
            }
            // 遍历所有节点
            max = Math.max(count(root.left, root.val) + count(root.right, root.val), max);
            help(root.left);
            help(root.right);
        }

        /**
         * 记录与当节点值相同的子节点数量(连续的)
         */
        private int count(TreeNode root, int target) {
            if (root == null || root.val != target) {
                return 0;
            }
            return Math.max(count(root.left, target), count(root.right, target)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}