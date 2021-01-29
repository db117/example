//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 398 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 199.二叉树的右视图.binary-tree-right-side-view
 *
 * @author db117
 * @since 2021-01-29 18:13:04
 **/

public class Solution_199 {
    public static void main(String[] args) {
        Solution solution = new Solution_199().new Solution();

        System.out.println(solution.rightSideView(TreeNodeUtil.build(new Integer[]{
                1, 2, 3, null, 5, null, 4
        })));
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
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();

            // 广度优先
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(root);

            while (!deque.isEmpty()) {
                ans.add(deque.peekLast().val);
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode first = deque.pollFirst();
                    if (first.left != null) {
                        deque.offerLast(first.left);
                    }
                    if (first.right != null) {
                        deque.offerLast(first.right);
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}