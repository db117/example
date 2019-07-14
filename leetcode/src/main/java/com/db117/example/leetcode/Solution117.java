package com.db117.example.leetcode;

import com.db117.example.leetcode.com.db117.example.Util.Node;
import lombok.extern.slf4j.Slf4j;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * <p>
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 * <p>
 * 提示：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/12
 **/
@Slf4j
public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node cur = root;
        while (cur != null) {
            // 当前节点下一级需要连接的节点
            Node nodeNext = null;
            // 下一个节点不为空
            if (cur.next != null) {
                Node next = cur;
                // 一直找到找不到为止
                while (next.next != null && nodeNext == null) {
                    nodeNext = next.next.left == null ? next.next.right : next.next.left;
                    next = next.next;
                }
            }

            // 左右子节点都不为空
            if (cur.left != null && cur.right != null) {
                cur.left.next = cur.right;
                cur.right.next = nodeNext;
            } else if (cur.left != null) {
                // 右为空
                cur.left.next = nodeNext;
            } else if (cur.right != null) {
                // 左为空
                cur.right.next = nodeNext;
            }

            cur = cur.next;
        }

        // 找到下一层最左边的节点的父节点
        Node nextLeftPrent = root;
        while (nextLeftPrent != null && nextLeftPrent.left == null && nextLeftPrent.right == null) {
            nextLeftPrent = nextLeftPrent.next;
        }
        // 没有找到直接结束
        if (nextLeftPrent == null) {
            return root;
        }

        if (nextLeftPrent.left != null) {
            // 左节点不为空下一级从左边搞
            connect(nextLeftPrent.left);
        } else {
            connect(nextLeftPrent.right);
        }

        return root;
    }
}
