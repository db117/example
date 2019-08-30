package com.db117.example.leetcode.solution2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/30/030
 */
public class Solution295 {
    class MedianFinder {
        // 大小堆
        private PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        private PriorityQueue<Integer> min = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (min.isEmpty() || num > min.peek()) {
                min.add(num);
            } else {
                max.add(num);
            }

            // 平衡两个堆数量
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            }
            if (max.size() > min.size() + 1) {
                min.add(max.poll());
            }
        }

        public double findMedian() {
            int maxSize = max.size();
            int minSize = min.size();

            // 取数量多的堆
            if (maxSize == minSize) {
                return (max.peek() + min.peek()) / 2d;
            } else if (maxSize > minSize) {
                return max.peek();
            } else {
                return min.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
