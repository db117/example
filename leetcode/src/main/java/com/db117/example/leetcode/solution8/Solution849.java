package com.db117.example.leetcode.solution8;

/**
 * 849. 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * <p>
 * 至少有一个空座位，且至少有一人坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 * <p>
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/15/015 18:29
 */
public class Solution849 {
    public static void main(String[] args) {
        System.out.println(new Solution849().maxDistToClosest(new int[]{
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0
        }));
    }

    public int maxDistToClosest(int[] seats) {
        // 最大间距
        int max = 0;
        // 最后一个人的位置
        int last = 0;
        // 第一个人的为位置
        Integer first = null;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (first == null) {
                    first = i;
                }
                max = Math.max(max, i - last);
                last = i;
            }
        }
        // 座在开头结尾的情况,左或者右没有人
        int temp = Math.max(first == null ? 0 : first, seats.length - 1 - last);
        // 坐在中间,左右都有人
        int mid = max >> 1;
        return Math.max(mid, temp);
    }
}
