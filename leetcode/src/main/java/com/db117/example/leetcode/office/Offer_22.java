//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 122 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeBuilder;

/**
 * 剑指 Offer 22.链表中倒数第k个节点.lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * @author db117
 * @since 2021-01-13 17:24:15
 **/

public class Offer_22 {
    public static void main(String[] args) {
        Solution solution = new Offer_22().new Solution();
        ListNodeBuilder.print(solution.getKthFromEnd(ListNodeBuilder.builder(new int[]{
                1, 2, 3, 4, 5, 6, 7
        }), 2));
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            int n = 0;
            ListNode left = head, right = head;
            while (right != null) {
                right = right.next;
                n++;
                if (n > k) {
                    left = left.next;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}