//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
// 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2: 
//
// 输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树 
// 👍 105 👎 0


package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 671.二叉树中第二小的节点
 *
 * @author db117
 * @date 2020-09-22 14:45:49
 **/
public class Solution671 {
    public static void main(String[] args) {
        Solution solution = new Solution671().new Solution();

        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 8
        });
        System.out.println(solution.findSecondMinimumValue(node));
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
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null || root.left == null) {
                return -1;
            }

            return help(root, root.val);
        }

        // 第一个大于n的数
        private int help(TreeNode root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.val > n) {
                return root.val;
            }
            // 找到左边比根节点大的最小值
            int left = help(root.left, n);
            int right = help(root.right, n);
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            // 左右都有比跟节点大的值,返回最小的那个
            return Math.min(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}