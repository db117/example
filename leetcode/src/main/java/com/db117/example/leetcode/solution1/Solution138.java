package com.db117.example.leetcode.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 * <p>
 * 提示：
 * <p>
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/9/009
 **/
public class Solution138 {
    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 先从缓存获取
        if (map.containsKey(head)) {
            return map.get(head);
        }
        // 赋值节点
        Node newNode = new Node(head.val, null, null);

        // 放入缓存
        map.put(head, newNode);

        // 赋值下一个节点
        newNode.next = copyRandomList(head.next);

        // 复制随机节点
        newNode.random = copyRandomList(head.random);

        return newNode;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}
