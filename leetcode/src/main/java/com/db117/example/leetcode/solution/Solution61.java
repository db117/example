package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.util.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/1
 **/

public class Solution61 {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        ListNode last = new ListNode(data[0]);
        ListNode head = last;
        for (int i = 1; i < data.length; i++) {
            last.next = new ListNode(data[i]);
            last = last.next;
        }


        ListNode res = new Solution61().rotateRight(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 收尾链接,并计算出size
        int size = 1;
        ListNode last = head;
        while (last.next != null) {
            size++;
            last = last.next;
        }
        last.next = head;

        // 计算出新头的位置
        int index = size - (k % size);

        // 找到新头
        for (int i = 0; i < index; i++) {
            last = head;
            head = head.next;
        }
        // 尾部置空
        last.next = null;

        return head;
    }
}
