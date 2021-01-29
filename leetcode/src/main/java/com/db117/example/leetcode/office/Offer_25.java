


//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 76 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 剑指 Offer 25.合并两个排序的链表.he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
 * @author db117
 * @since 2021-01-13 14:09:27
 **/

public class Offer_25 {
    public static void main(String[] args) {
        Solution solution = new Offer_25().new Solution();
        ListNode node = solution.mergeTwoLists(ListNodeUtil.builder(new int[]{
                1, 3, 5, 7, 7, 9, 90
        }), ListNodeUtil.builder(new int[]{
                4, 6, 7, 8, 8, 9, 9, 40
        }));
        ListNodeUtil.print(node);

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

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 伪头结点
            ListNode head = new ListNode(0);
            // 当前结点
            ListNode cur = head;

            // 当前结点的下一个结点指向最小的
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    cur.next = l2;
                    l2 = l2.next;
                } else if (l2 == null || l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            return head.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}