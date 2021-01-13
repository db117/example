


//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 91 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;

/**
 * 剑指 Offer 27.二叉树的镜像.er-cha-shu-de-jing-xiang-lcof
 *
 * @author db117
 * @since 2021-01-13 14:19:04
 **/

public class Offer_27 {
    public static void main(String[] args) {
        Solution solution = new Offer_27().new Solution();
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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            // 镜像右节点
            TreeNode left = mirrorTree(root.left);
            // 左节点镜像
            root.left = mirrorTree(root.right);
            root.right = left;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}