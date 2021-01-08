


//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 深度优先搜索 
// 👍 68 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 面试题 04.02.最小高度树.minimum-height-tree-lcci
 *
 * @author db117
 * @since 2021-01-08 18:03:32
 **/

public class Interview_0402 {
    public static void main(String[] args) {
        Solution solution = new Interview_0402().new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{
                -10, -3, 0, 5, 9
        });
        TreeNodeUtil.preorderPrint(treeNode);
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        TreeNode helper(int[] nums, int start, int end) {
            if (end < start) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[start]);
            }
            // 找到跟节点
            int mid = start + ((end - start) >> 1);
            TreeNode node = new TreeNode(nums[mid]);

            // 构建子节点
            node.left = helper(nums, start, mid - 1);
            node.right = helper(nums, mid + 1, end);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}