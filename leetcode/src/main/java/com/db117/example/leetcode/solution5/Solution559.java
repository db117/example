package com.db117.example.leetcode.solution5;

import java.util.List;

/**
 * 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/16/016
 */
public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> children = root.children;
        // 子节点为空则高度为1
        if (children == null || children.size() == 0) {
            return 1;
        }
        int max = 0;
        // 变量所有子节点,找到最大的
        for (Node child : children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
