package com.db117.example.leetcode.solution8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/7/007
 **/
public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // 第一间打开的
        stack.push(0);

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer pop = stack.pop();
                // 如果去过则跳过
                if (set.contains(pop)) {
                    continue;
                }
                set.add(pop);

                // 把钥匙放到栈中
                rooms.get(pop).forEach(stack::push);
            }
        }

        // 看去过的房间是否等于总房间
        return set.size() == rooms.size();
    }
}
