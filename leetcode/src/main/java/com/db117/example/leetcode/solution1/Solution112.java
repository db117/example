package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.Util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 112. 路径总和
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 为空直接不是
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            // 当时子节点时,判断是否相等
            return sum == 0;
        }
        // 左节点或右节点有找到路径
        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}
