package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * ----1
 * ---- \
 * ------3
 * ---- /
 * ----2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/8/13/013 17:59
 **/
public class Solution530 {
    public static void main(String[] args) {
        TreeNode node = TreeNodeUtil.build(new Integer[]{
                236, 104, 701, null, 227, null, 911
        });
        System.out.println(new Solution530().getMinimumDifference(node));
    }

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    // 最小值
    private int min = Integer.MAX_VALUE;
    // 前置节点
    private TreeNode pre;

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);

        if (pre != null) {
            // 求差
            min = Math.min(min, root.val - pre.val);
        }
        // 中序遍历为升序,当前节点为前置节点
        pre = root;

        helper(root.right);

    }
}
