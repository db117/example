


//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,nu
//ll,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索 
// 👍 38 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 面试题 04.04.检查平衡性.check-balance-lcci
 *
 * @author db117
 * @since 2021-01-08 18:38:20
 **/

public class Interview_0404 {
    public static void main(String[] args) {
        Solution solution = new Interview_0404().new Solution();
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
            if (root == null || !ans) {
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            if (Math.abs(left - right) > 1) {
                ans = false;
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}