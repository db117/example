//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 108 👎 0


package com.db117.example.leetcode.solution9;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 993.二叉树的堂兄弟节点.cousins-in-binary-tree
 *
 * @author db117
 * @since 2020-11-23 14:41:16
 **/

public class Solution993 {
    public static void main(String[] args) {
        Solution solution = new Solution993().new Solution();
        //[10,1,2,3,4,5,6]
        //4
        //5
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                10, 1, 2, 3, 4, 5, 6
        });

        System.out.println(solution.isCousins(node, 5, 4));
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
        public boolean isCousins(TreeNode root, int x, int y) {
            // 当成完全二叉树,按堆的模式来找位置
            int xIndex = search(root, 1, x);
            int yIndex = search(root, 1, y);


            // 判断是否是同一个父节点
            if ((xIndex / 2) == (yIndex / 2)) {
                return false;
            }

            // 根据索引判断是否在同一层
            return Integer.highestOneBit(xIndex) == Integer.highestOneBit(yIndex);
        }

        /**
         * 找到节点的位置
         *
         * @param node   当前节点
         * @param index  当前节点索引
         * @param search 需要找的数字
         */
        public int search(TreeNode node, int index, int search) {
            if (node == null) {
                return -1;
            }
            if (node.val == search) {
                return index;
            }

            int left = search(node.left, index * 2, search);
            if (left != -1) {
                return left;
            }

            return search(node.right, index * 2 + 1, search);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}