//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 54 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 面试题 02.02.返回倒数第 k 个节点.kth-node-from-end-of-list-lcci
 *
 * @author db117
 * @since 2021-01-19 15:08:21
 **/

public class Interview_0202 {
    public static void main(String[] args) {
        Solution solution = new Interview_0202().new Solution();
        System.out.println(solution.kthToLast(ListNodeUtil.builder(new int[]{
                1, 2, 3, 4, 5, 6
        }), 4));
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
        public int kthToLast(ListNode head, int k) {
            // 取高32位的数字
            return (int) (helper(head, k) >> 32);
        }

        public long helper(ListNode head, int k) {
            if (head == null) {
                return 0;
            }
            // 当前倒数第几
            long n = helper(head.next, k) + 1;

            if (n == k) {
                // 找到了,把当前的数字放到高32位
                n += ((long) head.val << 32);
            }

            return n;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}