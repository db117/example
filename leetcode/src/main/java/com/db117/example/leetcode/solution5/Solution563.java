//给定一个二叉树，计算整个树的坡度。
//
// 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。 
//
// 整个树的坡度就是其所有节点的坡度之和。 
//
// 
//
// 示例： 
//
// 输入：
//         1
//       /   \
//      2     3
//输出：1
//解释：
//结点 2 的坡度: 0
//结点 3 的坡度: 0
//结点 1 的坡度: |2-3| = 1
//树的坡度 : 0 + 0 + 1 = 1
// 
//
// 
//
// 提示： 
//
// 
// 任何子树的结点的和不会超过 32 位整数的范围。 
// 坡度的值不会超过 32 位整数的范围。 
// 
// Related Topics 树 
// 👍 81 👎 0


package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 563.二叉树的坡度
 *
 * @author db117
 * @date 2020-08-23 18:20:21
 **/
public class Solution563 {
    public static void main(String[] args) {
        Solution solution = new Solution563().new Solution();
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                1, 2, 3
        });
        System.out.println(solution.findTilt(node));
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
        int res = 0;

        public int findTilt(TreeNode root) {
            sum(root);
            return res;
        }

        int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            // 计算坡度
            res += Math.abs(leftSum - rightSum);

            return root.val + leftSum + rightSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}