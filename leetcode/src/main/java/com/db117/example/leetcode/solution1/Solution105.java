package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/

public class Solution105 {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    int[] preorder, inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // 构建缓存
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, preorder.length - 1);
    }

    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        // 前序遍历,从前面开始拿出根节点
        int val = preorder[preIndex++];
        // 找到中序遍历中的根节点位置
        Integer index = map.get(val);
        // 新建节点
        TreeNode root = new TreeNode(val);
        // 构建左子节点
        root.left = helper(start, index - 1);
        // 构建右子节点
        root.right = helper(index + 1, end);

        return root;
    }
}
