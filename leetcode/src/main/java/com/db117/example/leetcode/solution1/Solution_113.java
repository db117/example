

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 418 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113.路径总和 II.path-sum-ii
 *
 * @author db117
 * @since 2021-01-26 14:27:11
 **/

public class Solution_113 {
    public static void main(String[] args) {
        Solution solution = new Solution_113().new Solution();
        // [-2,null,-3]
        //-5
        // [[-2,-3]]
        System.out.println(solution.pathSum(TreeNodeUtil.build(new Integer[]{
                -2, null, -3
        }), -5));
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new LinkedList<>();

            helper(ans, new LinkedList<>(), root, targetSum, 0);
            return ans;
        }

        void helper(List<List<Integer>> ans, List<Integer> cur, TreeNode root, int target, int curSum) {
            if (root == null) {
                return;
            }

            // 结束条件
            curSum += root.val;
            cur.add(root.val);

            if (root.left == null
                    && root.right == null
                    && target == curSum) {
                ans.add(new ArrayList<>(cur));
                // 从当前集合中删除掉,不影响后面的节点
                cur.remove(cur.size() - 1);
                return;
            }


            helper(ans, cur, root.left, target, curSum);

            helper(ans, cur, root.right, target, curSum);

            cur.remove(cur.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}