//对链表进行插入排序。
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 341 👎 0


package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 147.对链表进行插入排序.insertion-sort-list
 *
 * @author db117
 * @since 2021-01-29 15:04:54
 **/

public class Solution_147 {
    public static void main(String[] args) {
        Solution solution = new Solution_147().new Solution();
        ListNode builder = ListNodeUtil.builder(new int[]{
                1, 2, 3, 3, 4, 4, 5, 5, 6, 6
        });
        ListNodeUtil.print(solution.insertionSortList(builder));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode tmp = new ListNode(Integer.MIN_VALUE);
            tmp.next = head;

            ListNode pre = tmp, cur = head, next, insertPre;
            while (cur != null) {
                if (cur.val >= pre.val) {
                    // 本来就是有序的
                    pre = cur;
                    cur = cur.next;
                    continue;
                }

                // 删除当前节点
                next = cur.next;
                cur.next = null;
                pre.next = next;

                // 插入当前节点
                insertPre = tmp;
                while (insertPre.next != null) {
                    if (insertPre.next.val > cur.val) {
                        insert(insertPre, cur);
                        break;
                    } else {
                        insertPre = insertPre.next;
                    }
                }
                cur = next;
            }

            return tmp.next;
        }

        void insert(ListNode head, ListNode insertNode) {
            if (head == null) {
                return;
            }
            ListNode next = head.next;
            head.next = insertNode;
            insertNode.next = next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}