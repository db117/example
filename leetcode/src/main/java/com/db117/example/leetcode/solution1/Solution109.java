package com.db117.example.leetcode.solution1;

import com.db117.example.leetcode.Util.ListNode;
import com.db117.example.leetcode.Util.ListNodeBuilder;
import com.db117.example.leetcode.Util.TreeNode;
import com.db117.example.leetcode.Util.TreeNodeUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/19
 **/
@Slf4j
public class Solution109 {
    public static void main(String[] args) {
        ListNode builder = ListNodeBuilder.builder(new int[]{-10, -3, 0, 5, 9});
        TreeNode helper = new Solution109().helper(builder);
        TreeNodeUtil.inorderPrint(helper);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    public TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        // 没有下一个节点就直接返回
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 通过快慢指针找到中点
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        // 断开链表
        ListNode mid = slow;
        pre.next = null;

        // 根节点
        TreeNode root = new TreeNode(mid.val);

        // 构建左结点
        root.left = helper(head);
        // 构建右节点
        root.right = helper(mid.next);
        return root;
    }
}
