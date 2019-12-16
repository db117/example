package com.db117.example.leetcode.solution8;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 给定的两颗树可能会有 1 到 100 个结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/16/016 11:11
 */
public class Solution872 {
    public static void main(String[] args) {
        // [3,5,1,6,2,9,8,null,null,7,4]
        //[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode root1 = TreeNodeUtil.build(new Integer[]{
                3, 5, 1, 6, 2, 9, 8, null, null, 7, 4
        });
        TreeNode root2 = TreeNodeUtil.build(new Integer[]{
                3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8
        });
        System.out.println(new Solution872().leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        // 从左往右添加叶子节点
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
