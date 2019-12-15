package com.db117.example.leetcode.solution8;

/**
 * 868. 二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 
 * <p>
 * 如果没有两个连续的 1，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 * 示例 3：
 * <p>
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 * 示例 4：
 * <p>
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/13/013 17:12
 */
public class Solution868 {
    public static void main(String[] args) {
        System.out.println(new Solution868().binaryGap(8));
    }

    public int binaryGap(int N) {

        int max = 0;
        // 最后出现的位置
        int last = -1;
        for (int i = 0; i < 32; i++) {
            int i1 = N >> i;
            if (i1 < 0) {
                // 左边没有1了直接结束
                break;
            }
            // 找到1
            if ((i1 & 1) == 1) {
                // 不是第一个
                if (last != -1) {
                    max = Math.max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
}
