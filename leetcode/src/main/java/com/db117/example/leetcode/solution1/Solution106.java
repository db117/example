package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.Util.TreeNode;
import com.db117.example.leetcode.Util.TreeNodeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Solution106 {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution106().buildTree(new int[]{
                9, 3, 15, 20, 7
        }, new int[]{
                9, 15, 7, 20, 3
        });

        TreeNodeUtil.inorderPrint(treeNode);
    }

    // 缓存中序 值->下标
    Map<Integer, Integer> map = new HashMap<>();
    // 后序排序下标
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        // 构建缓存
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // 后续遍历最后一个节点为根节点
        int val = postorder[postIndex--];
        // 找到中序遍历的根节点
        Integer rootIndex = map.get(val);
        // 新建根节点
        TreeNode root = new TreeNode(val);
        // 需要先构建右节点,因为后序遍历的根节点是从右节点开始
        // 构建右节点
        root.right = helper(inorder, postorder, rootIndex + 1, end);
        // 构建左节点
        root.left = helper(inorder, postorder, start, rootIndex - 1);
        return root;
    }
}
