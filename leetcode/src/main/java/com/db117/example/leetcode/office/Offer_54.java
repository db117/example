


//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 105 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 剑指 Offer 54.二叉搜索树的第k大节点.er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * @author db117
 * @since 2021-01-15 11:27:30
 **/

public class Offer_54 {
    public static void main(String[] args) {
        Solution solution = new Offer_54().new Solution();
        System.out.println(solution.kthLargest(TreeNodeUtil.build(new Integer[]{
                5, 3, 6, 2, 4, null, null, 1
        }), 6));
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
        // 第几大的数字
        int n = 0;
        int ans;

        public int kthLargest(TreeNode root, int k) {
            helper(root, k);
            return ans;
        }

        void helper(TreeNode root, int k) {
            if (root == null) {
                return;
            }

            helper(root.right, k);
            n++;
            if (n == k) {
                ans = root.val;
            }
            helper(root.left, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}