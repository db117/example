package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/18/018 10:08
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        // 方向
        boolean flag = true;
        deque.add(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll;
                poll = deque.pollFirst();
                row.add(poll.val);

                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            // 如果是逆序翻转
            if (!flag) {
                Collections.reverse(row);
            }
            res.add(row);
            // 转变方向
            flag = !flag;
        }
        return res;
    }
}
