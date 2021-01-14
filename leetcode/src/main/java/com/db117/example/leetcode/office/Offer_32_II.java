


//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 75 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 剑指 Offer 32 - II.从上到下打印二叉树 II.cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *
 * @author db117
 * @since 2021-01-14 14:14:48
 **/

public class Offer_32_II {
    public static void main(String[] args) {
        Solution solution = new Offer_32_II().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            // 广度优先
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>(size);

                IntStream.range(0, size)
                        .mapToObj(i -> queue.poll())
                        .forEach(node -> {
                            list.add(node.val);
                            if (node.left != null) {
                                queue.offer(node.left);
                            }
                            if (node.right != null) {
                                queue.offer(node.right);
                            }
                        });

                ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}