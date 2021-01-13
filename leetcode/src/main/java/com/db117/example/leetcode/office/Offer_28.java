


//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 118 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 28.对称的二叉树.dui-cheng-de-er-cha-shu-lcof
 *
 * @author db117
 * @since 2021-01-13 14:22:15
 **/

public class Offer_28 {
    public static void main(String[] args) {
        Solution solution = new Offer_28().new Solution();
        System.out.println(solution.isSymmetric(TreeNodeUtil.build(new Integer[]{
                1, 2, 2, null, 3, null, 3
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
        public boolean isSymmetric(TreeNode root) {
            // 递归
            if (root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        boolean helper(TreeNode left, TreeNode right) {
            // 结束条件
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }

            helper(left.right, right.left);
            return /* 镜像外侧 */ helper(left.left, right.right) && /* 镜像内侧 */helper(left.right, right.left);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    // 迭代
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            // 分成左右两个队列,即两个队列互为镜像
            Queue<TreeNode> leftQueue = new LinkedList<>();
            Queue<TreeNode> rightQueue = new LinkedList<>();
            leftQueue.offer(root.left);
            rightQueue.offer(root.right);

            while (!leftQueue.isEmpty() && leftQueue.size() == rightQueue.size()) {
                int size = leftQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode left = leftQueue.poll();
                    TreeNode right = rightQueue.poll();
                    if (left == null && null == right) {
                        continue;
                    }
                    // 不相等则非镜像
                    if (left == null || right == null) {
                        return false;
                    }
                    if (left.val != right.val) {
                        return false;
                    }
                    // 同一层的最边上
                    leftQueue.offer(left.left);
                    rightQueue.offer(right.right);

                    leftQueue.offer(left.right);
                    rightQueue.offer(right.left);
                }
            }
            return true;
        }

    }
}