package com.db117.example.leetcode.solution3;

import com.db117.example.leetcode.Util.TreeNode;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *      3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/22/022
 **/

public class Solution337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 根节点偷则不能偷子节点
        int in = root.val;
        if (root.left != null) {
            // 加上子节点的子节点的最大值
            in += rob(root.left.left);
            in += rob(root.left.right);
        }
        if (root.right != null) {
            in += rob(root.right.left);
            in += rob(root.right.right);
        }
        // 不偷根节点
        int notIn = rob(root.left) + rob(root.right);

        // 返回最大的
        return Math.max(in, notIn);
    }

}
