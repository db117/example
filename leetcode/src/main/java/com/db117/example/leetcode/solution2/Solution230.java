package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.Util.TreeNode;
import com.db117.example.leetcode.Util.TreeNodeUtil;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * ....3
 * .../ \
 * ..1   4
 * ...\
 * ....2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * ........5
 * ......./ \
 * ......3   6
 * ...../ \
 * ....2   4
 * .../
 * ..1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/5/005 10:27
 */
public class Solution230 {
    public static void main(String[] args) {
        System.out.println(new Solution230().kthSmallest(TreeNodeUtil.build(new Integer[]{
                3, 1, 4, null, 2
        }), 4));
    }

    int res;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        // 中序遍历
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null || k < 0) {
            return;
        }

        helper(root.left);
        k--;
        if (k == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
