package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/18
 **/

public class Solution234 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.builder(new int[]{1, 2, 1});
        System.out.println(new Solution234().isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        ListNode pre = head, last;

        while (fast != null && fast.next != null) {
            // 快指针两倍速
            // 先移动快指针,不然会出问题
            fast = fast.next.next;
            // 翻转慢指针
            last = slow.next;
            slow.next = pre;
            pre = slow;
            slow = last;
        }

        // 已经翻转的链表头
        ListNode p1 = pre;
        // 未翻转的链表头
        ListNode p2 = fast == null ? slow : slow.next;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
