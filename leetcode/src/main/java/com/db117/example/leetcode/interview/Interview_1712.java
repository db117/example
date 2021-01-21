//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 57 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 面试题 17.12.BiNode.binode-lcci
 *
 * @author db117
 * @since 2021-01-21 18:14:39
 **/

public class Interview_1712 {
    public static void main(String[] args) {
        Solution solution = new Interview_1712().new Solution();

        TreeNodeUtil.inorderPrint(solution.convertBiNode(TreeNodeUtil.build(new Integer[]{
                4, 2, 5, 1, 3, null, 6, 0
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
        TreeNode head = new TreeNode(Integer.MIN_VALUE);
        TreeNode pre;

        public TreeNode convertBiNode(TreeNode root) {

            if (root == null) {
                return root;
            }

            dfs(root);

            return head.right;
        }


        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);

            if (pre == null) {
                // 头结点
                pre = root;
                head.right = root;
            } else {
                // 上一个节点指向当前节点
                pre.right = root;
                // 往下走
                pre = root;
            }
            root.left = null;

            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}