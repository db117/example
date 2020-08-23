//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 452 👎 0


package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 543.二叉树的直径
 *
 * @author db117
 * @date 2020-08-23 17:44:54
 **/
public class Solution543 {
    public static void main(String[] args) {
        Solution solution = new Solution543().new Solution();

        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1, 2, 3, 4, 5, 6, 7, 8
        });

        System.out.println(solution.diameterOfBinaryTree(node));
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
        int maxLength = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);

            return maxLength;
        }

        void helper(TreeNode root) {
            if (root == null) {
                return;
            }
            // 左右的最大深度加自己就是以自己为跟的最大长度
            int length = maxDepth(root.left) + maxDepth(root.right);
            maxLength = Math.max(length, maxLength);
            helper(root.left);
            helper(root.right);
        }

        // 最大深度
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}