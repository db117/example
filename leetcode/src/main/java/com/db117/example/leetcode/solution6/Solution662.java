package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/10/010 17:47
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        // 堆排序,把val改为索引
        root.val = 0;

        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.pollFirst();
                TreeNode leftNode = poll.left;
                TreeNode rightNode = poll.right;


                if (leftNode != null) {
                    leftNode.val = poll.val * 2 + 1;
                    // 修改当前层的最左,最右
                    left = Math.min(left, leftNode.val);
                    right = Math.max(right, leftNode.val);
                    deque.addLast(leftNode);
                }
                if (poll.right != null) {
                    rightNode.val = poll.val * 2 + 2;
                    left = Math.min(left, rightNode.val);
                    right = Math.max(right, rightNode.val);
                    deque.addLast(poll.right);
                }

                if (right > left) {
                    // 找到两个节点级以上时
                    max = Math.max(max, right - left);
                }
            }
        }
        // 宽度
        return max + 1;
    }
}
