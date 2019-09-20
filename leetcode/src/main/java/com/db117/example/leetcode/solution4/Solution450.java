package com.db117.example.leetcode.solution4;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * .....5
 * ..../ \
 * ...3   6
 * ../ \   \
 * .2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * .....5
 * ..../ \
 * ...4   6
 * ../     \
 * .2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * .....5
 * ..../ \
 * ...2   6
 * ....\   \
 * .....4   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/15/015
 */
public class Solution450 {
    public static void main(String[] args) {
        TreeNode build = TreeNodeUtil.build(new Integer[]{
                3, 1, 4, null, 2
        });
        TreeNode node = new Solution450().deleteNode(build, 3);
        TreeNodeUtil.preorderPrint(node);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 需要删除的在右边
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // 需要删除的节点在左边
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        // 找到
        // 左节点为空
        if (root.left == null) {
            return root.right;
        }
        // 右节点为空
        if (root.right == null) {
            return root.left;
        }
        // 都不为空
        // 先找到左节点的最大值
        TreeNode max = max(root.left);
        // 不复制会循环引用
        TreeNode maxCopy = new TreeNode(max.val);
        maxCopy.right = root.right;
        // 删除节点
        maxCopy.left = delMax(root.left);

        root.left = null;
        root.right = null;

        return maxCopy;
    }

    public TreeNode max(TreeNode root) {
        // 找到左节点的最大节点
        if (root.right == null) {
            return root;
        }
        // 一直找到右节点为空的右节点
        return max(root.right);
    }

    public TreeNode delMax(TreeNode root) {
        // 删除左节点的最大节点
        if (root.right == null) {
            return root.left;
        }
        root.right = delMax(root.right);
        return root;
    }
}
