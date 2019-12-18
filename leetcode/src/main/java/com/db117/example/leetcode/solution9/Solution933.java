package com.db117.example.leetcode.solution9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 933. 最近的请求次数
 * 写一个 RecentCounter 类来计算最近的请求。
 * <p>
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * <p>
 * 返回从 3000 毫秒前到现在的 ping 数。
 * <p>
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * <p>
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个测试用例最多调用 10000 次 ping。
 * 每个测试用例会使用严格递增的 t 值来调用 ping。
 * 每次调用 ping 都有 1 <= t <= 10^9。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/18/018 15:41
 */
public class Solution933 {
    class RecentCounter {
        Deque<Integer> deque;

        public RecentCounter() {
            deque = new LinkedList<>();
        }

        public int ping(int t) {
            if (!deque.isEmpty() && deque.peekFirst() + 3000 < t) {
                // 上一个数字小于当前数字3000以上,清空
                deque.clear();
            }

            while (!deque.isEmpty() && (deque.peekLast() + 3000 < t)) {
                // 删除小于当前数字3000的数字
                deque.pollLast();
            }
            deque.addFirst(t);
            return deque.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
