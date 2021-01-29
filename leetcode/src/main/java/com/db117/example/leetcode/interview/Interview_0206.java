


//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 40 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 面试题 02.06.回文链表.palindrome-linked-list-lcci
 *
 * @author db117
 * @since 2021-01-08 11:54:42
 **/

public class Interview_0206 {
    public static void main(String[] args) {
        Solution solution = new Interview_0206().new Solution();
        System.out.println(solution.isPalindrome(ListNodeUtil.builder(new int[]{
                1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1
        })));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            // 快慢指针,翻转链表

            ListNode mid = findMid(head);
            ListNode reverse = reverse(mid.next);

            while (reverse != null) {
                if (head.val != reverse.val) {
                    return false;
                }
                head = head.next;
                reverse = reverse.next;
            }


            return true;
        }

        // 找到中点
        ListNode findMid(ListNode head) {
            ListNode low = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                low = low.next;
            }
            return low;
        }

        // 翻转链表
        ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head, pre = null;

            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}