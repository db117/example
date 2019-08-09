package com.db117.example.leetcode.solution4;

/**
 * 430. 扁平化多级双向链表
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1---2---3---4---5---6--NULL
 * ........|
 * ........7---8---9---10--NULL
 * ............|
 * ............11--12--NULL
 * <p>
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 *  
 * <p>
 * 以上示例的说明:
 * <p>
 * 给出以下多级双向链表:
 * <p>
 * <p>
 *  
 * <p>
 * 我们应该返回如下所示的扁平双向链表:
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/8/008
 **/
public class Solution430 {
    public Node flatten(Node head) {
        Node pre = new Node();
        dfs(head, pre);
        return pre.next;
    }

    public void dfs(Node head, Node pre) {
        if (head == null) {
            return;
        }
        // 后序节点
        dfs(head.next, pre);
        // 子链表
        dfs(head.child, pre);
        head.child = null;

        // 递归到最后一个节点,反向处理
        // 使用pre.next保存当前处理的节点,即后节点

        // 当前节点的后置节点
        Node next = pre.next;
        // 保存当前节点,上一层需要
        pre.next = head;
        // 当前节点指向保存的后序节点
        head.next = next;
        if (next != null) {
            // 不为空设置前驱
            next.prev = head;
        }
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;
}
