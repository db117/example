


//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 83 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

import java.util.Arrays;

/**
 * 剑指 Offer 06.从尾到头打印链表.cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 * @author db117
 * @since 2021-01-13 11:40:22
 **/

public class Offer_06 {
    public static void main(String[] args) {
        Solution solution = new Offer_06().new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(ListNodeUtil.builder(new int[]{
                1
        }))));
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
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            int size = 1;

            // 翻转后的链表头(假的)
            ListNode rh = new ListNode(0);
            rh.next = head;
            // 翻转连表并记录长度
            ListNode next = head.next;
            while (next != null) {
                ListNode tmp = next.next;

                next.next = rh.next;
                rh.next = next;

                next = tmp;
                size++;
            }

            // 根据翻转后的链表构建返回值
            rh = rh.next;
            int[] ans = new int[size];
            for (int i = 0; i < size; i++) {
                ans[i] = rh.val;
                rh = rh.next;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}