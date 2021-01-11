


//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。 
//
// 
//
// 示例： 
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表 
// 👍 74 👎 0


package com.db117.example.leetcode.interview;

import com.db117.example.leetcode.util.ListNode;

/**
 * 面试题 02.03.删除中间节点.delete-middle-node-lcci
 *
 * @author db117
 * @since 2021-01-11 11:58:56
 **/

public class Interview_0203 {
    public static void main(String[] args) {
        Solution solution = new Interview_0203().new Solution();
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
        public void deleteNode(ListNode node) {
            // 脑筋急转弯
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}