package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/18/018 18:35
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs("", root, res);

        return res;
    }

    private void dfs(String cur, TreeNode root, List<String> res) {

        String pre;
        // 前缀
        if (cur.isEmpty()) {
            pre = cur;
        } else {
            pre = cur + "->";
        }


        if (root.left == null && root.right == null) {
            // 没有子节点,即叶子节点
            res.add(pre + root.val);
        } else {
            if (root.left != null) {
                dfs(pre + root.val, root.left, res);
            }
            if (root.right != null) {
                dfs(pre + root.val, root.right, res);
            }

        }
    }
}
