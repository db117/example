//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Related Topics 树 
// 👍 179 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 剑指 Offer 68 - II.二叉树的最近公共祖先.er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 *
 * @author db117
 * @since 2021-01-18 17:47:46
 **/

public class Offer_68_II {
    public static void main(String[] args) {
        Solution solution = new Offer_68_II().new Solution();

        System.out.println(solution.lowestCommonAncestor(TreeNodeUtil.build(new Integer[]{
                3, 5, 1, 6, 2, 0, 8, null, null, 7, 4
        }), new TreeNode(5), new TreeNode(1)).val);
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            // 自己为根节点的情况
            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            // 找子节点存在存在的节点
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                // 一左一右
                return root;
            }

            // 数据肯定存在则,公共节点在非null的一侧
            return left != null ? left : right;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        // n*LogN
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // 在左边的数量
            int leftCount = count(root.left, p, q);
            // 在右边的数量
            int rightCount = count(root.right, p, q);

            if (leftCount == 2) {
                // 在左边
                return lowestCommonAncestor(root.left, p, q);
            }

            if (rightCount == 2) {
                // 在右边
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }

        // 统计当前节点及子节点包含 P,q的数量
        int count(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return 0;
            }
            int n = 0;
            if (root.val == p.val || root.val == q.val) {
                n++;
            }

            return count(root.left, p, q) + count(root.right, p, q) + n;
        }
    }
}