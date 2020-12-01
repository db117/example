//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 ->
// 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
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
// 示例 4： 
//
// 
//输入：root = [1,1]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数介于 1 和 1000 之间。 
// Node.val 为 0 或 1 。 
// 
// Related Topics 树 
// 👍 81 👎 0


package com.db117.example.leetcode.solution10;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 1022.从根到叶的二进制数之和.sum-of-root-to-leaf-binary-numbers
 *
 * @author db117
 * @since 2020-12-01 16:46:22
 **/

public class Solution1022 {
    public static void main(String[] args) {
        Solution solution = new Solution1022().new Solution();
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1
        });

        System.out.println(solution.sumRootToLeaf(node));
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
        public int sumRootToLeaf(TreeNode root) {
            int[] sum = new int[1];

            helper(root, 0, sum);

            return sum[0];
        }

        public void helper(TreeNode node, int pSum, int[] sum) {
            int n = pSum * 2 + node.val;
            // 叶子节点
            if (node.left == null && node.right == null) {
                sum[0] += n;
                return;
            }
            if (node.left != null) {
                helper(node.left, n, sum);
            }
            if (node.right != null) {
                helper(node.right, n, sum);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}