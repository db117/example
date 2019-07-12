package com.db117.example.leetcode;

import com.db117.example.leetcode.com.db117.example.Util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        // 翻转
        Collections.reverse(res);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode treeNode, int depth) {
        if (treeNode == null) {
            return;
        }
        // 当前深度大于数组长度
        if (depth > res.size() - 1) {
            res.add(new ArrayList<>());
        }
        // 添加到本层
        res.get(depth).add(treeNode.val);
        // 左
        helper(res, treeNode.left, depth + 1);
        // 右
        helper(res, treeNode.right, depth + 1);
    }
}
