package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.Util.TreeNode;
import com.db117.example.leetcode.Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/11
 **/

public class Solution95 {
    public static void main(String[] args) {
        for (TreeNode treeNode : new Solution95().generateTrees(5)) {
            TreeNodeUtil.preorderPrint(treeNode);
            System.out.println("---");
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res.add(null);
        // 添加数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> temp = new ArrayList<>();
            // 遍历以前的所有解
            int size = res.size();
            for (int j = 0; j < size; j++) {
                // 把当前节点作为根节点,以前的作为左节点
                TreeNode node = res.get(j);
                TreeNode newNode = new TreeNode(i);
                newNode.left = node;
                temp.add(newNode);
                // 循环把当前节点插入到所有右节点
                for (int k = 0; k <= n; k++) {
                    TreeNode treeCopy = treeCopy(node);
                    TreeNode right = treeCopy;

                    // 找到第k个右节点
                    for (int l = 0; l < k; l++) {
                        if (right != null) {
                            right = right.right;
                        } else {
                            // 为空结束
                            break;
                        }
                    }

                    // 为空结束
                    if (right == null) {
                        break;
                    }

                    // 把当前节点的右节点保存为新节点的左节点
                    newNode = new TreeNode(i);
                    newNode.left = right.right;
                    // 把当前节点放到右节点的右节点
                    right.right = newNode;

                    // 把复制的树保存
                    temp.add(treeCopy);
                }
            }
            res = temp;
        }
        return res;
    }

    /**
     * 复制的树
     *
     * @param root 根节点
     * @return 复制的树
     */
    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }
}
