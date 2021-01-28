

// 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 305 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 129.求根到叶子节点数字之和.sum-root-to-leaf-numbers
 *
 * @author db117
 * @since 2021-01-28 11:07:58
 **/

public class Solution_129 {
    public static void main(String[] args) {
        Solution solution = new Solution_129().new Solution();
        TreeNode treeNode = TreeNodeUtil.build(new Integer[]{
                4, 9, 0, 5, 1
        });

        System.out.println(solution.sumNumbers(treeNode));
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
        int sum = 0;

        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return sum;
        }

        void helper(TreeNode root, int cur) {
            if (root == null) {
                return;
            }

            cur *= 10;
            cur += root.val;
            if (root.left == null && root.right == null) {
                sum += cur;
                return;
            }

            if (root.left != null) {
                helper(root.left, cur);
            }

            if (root.right != null) {
                helper(root.right, cur);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}