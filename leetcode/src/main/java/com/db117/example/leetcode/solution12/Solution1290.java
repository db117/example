package com.db117.example.leetcode.solution12;

import com.db117.example.leetcode.util.ListNode;
import com.db117.example.leetcode.util.ListNodeUtil;

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/31/031 14:41
 */
public class Solution1290 {
    public static void main(String[] args) {
        ListNode builder = ListNodeUtil.builder(new int[]{
                1
        });

        System.out.println(new Solution1290().getDecimalValue(builder));
    }

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        int num = -1;
        ListNode node = head;
        // 找到链表的长度
        while (node != null) {
            node = node.next;
            num++;
        }

        while (head != null) {
            if (head.val == 1) {
                ans |= (head.val << num);
            }
            head = head.next;
            num--;
        }
        return ans;
    }
}
