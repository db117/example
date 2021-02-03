// 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 104] 
// 0 <= Node.val <= 5 * 104 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 二分查找 
// 👍 429 👎 0


package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 222.完全二叉树的节点个数.count-complete-tree-nodes
 *
 * @author db117
 * @since 2021-02-03 15:47:50
 **/

public class Solution_222 {
    public static void main(String[] args) {
        Solution solution = new Solution_222().new Solution();
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        });

        System.out.println(solution.countNodes(node));
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
        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            // 子树的高度
            int leftHigh = helper(root.left);
            if (leftHigh == 0) {
                // 只剩当前节点
                return 1;
            }
            int rightHigh = helper(root.right);
            if (rightHigh == 0) {
                // 还有当前节点和左节点
                return 2;
            }

            if (leftHigh == rightHigh) {
                // 说明左子树最低层是满的
                int rightCount = countNodes(root.right);
                return (1 << leftHigh) + rightCount;
            } else {
                // 右子树最底层是满的
                int leftCount = countNodes(root.left);
                return (1 << rightHigh) + leftCount;
            }

        }

        // 完全二叉树的高度
        int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return helper(root.left) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}