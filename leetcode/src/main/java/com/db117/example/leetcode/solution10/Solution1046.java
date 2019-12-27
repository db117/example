package com.db117.example.leetcode.solution10;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/27/027 14:36
 */
public class Solution1046 {
    public static void main(String[] args) {
        System.out.println(new Solution1046().lastStoneWeight(new int[]{
                1, 2, 3, 4, 4
        }));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            Integer first = queue.poll();
            Integer two = queue.poll();
            if (!first.equals(two)) {
                queue.offer(first - two);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
