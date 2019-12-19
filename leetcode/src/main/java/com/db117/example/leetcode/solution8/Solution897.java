package com.db117.example.leetcode.solution8;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

/**
 * 897. 递增顺序查找树
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 *  /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 * 9
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/19/019 15:00
 */
public class Solution897 {
    public static void main(String[] args) {
        TreeNode build = TreeNodeUtil.build(new Integer[]{
                1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9
        });
        TreeNode bst = new Solution897().increasingBST(build);
        TreeNodeUtil.preorderPrint(bst);
    }

    private TreeNode ans;
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (ans == null) {
            ans = new TreeNode(root.val);
            pre = ans;
        } else {
            pre.right = new TreeNode(root.val);
            pre = pre.right;
        }

        helper(root.right);
    }

}
