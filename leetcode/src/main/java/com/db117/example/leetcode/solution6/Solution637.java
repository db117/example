package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * -----3
 * ----/ \
 * ---9  20
 * -----/  \
 * ---15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/8/6/006 16:46
 **/
public class Solution637 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.build(new Integer[]{
                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE
        });
        System.out.println(new Solution637().averageOfLevels(treeNode));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        // 广度优先遍历
        Deque<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while (!temp.isEmpty()) {
            int size = temp.size();
            // 和可能超过最大integer的值
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode last = temp.pollLast();
                sum += last.val;
                if (last.left != null) {
                    temp.addFirst(last.left);
                }
                if (last.right != null) {
                    temp.addFirst(last.right);
                }

            }
            // 平均值
            res.add(sum / (size * 1D));
        }
        return res;
    }
}
