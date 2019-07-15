package com.db117.example.leetcode.solution;

import com.db117.example.leetcode.Util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/11
 **/
@Slf4j
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 拆到一个时直接返回
        if (lists.length == 1) {
            return lists[0];
        }
        // 拆到2个时进行递归合并
        if (lists.length == 2) {
            return mergeTwo(lists[1], lists[0]);
        }

        int mid = lists.length >> 1;
        // 拆分到只剩一个或2个为止
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[lists.length - mid];
        System.arraycopy(lists, 0, left, 0, mid);
        System.arraycopy(lists, mid, right, 0, lists.length - mid);
        // 两两合并
        return mergeTwo(mergeKLists(left), mergeKLists(right));
    }

    /**
     * 合并两个
     *
     * @param left  第一个
     * @param right 第二个
     * @return 合并后的
     */
    ListNode mergeTwo(ListNode left, ListNode right) {
        // 终止条件
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.val < right.val) {
            // 左比较小,继续调用找到左的下一个
            left.next = mergeTwo(left.next, right);
            return left;
        } else {
            // 同理
            right.next = mergeTwo(left, right.next);
            return right;
        }
    }
}
