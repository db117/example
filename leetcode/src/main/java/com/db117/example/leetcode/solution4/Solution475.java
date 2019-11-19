package com.db117.example.leetcode.solution4;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * <p>
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * <p>
 * 说明:
 * <p>
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 * <p>
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/19/019 14:17
 */
public class Solution475 {
    public static void main(String[] args) {
        //[282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
        //[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]
        // 161834419
        System.out.println(new Solution475().findRadius(
                new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923}
                , new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            // 找到每个房子最近的暖气
            max = Math.max(max, min(house, heaters));
        }
        return max;
    }

    public int min(int s, int[] heaters) {
        // 二分查找
        int left = 0, right = heaters.length - 1, len = heaters.length;

        if (len == 1) {
            // 只有一个暖气时
            return Math.abs(s - heaters[0]);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (heaters[mid] > s) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (heaters[left] == s) {
            return 0;
        }
        // 获取到与目标值最小的差
        return Math.min(Math.abs(s - heaters[left])
                , Math.abs(s - heaters[left == len - 1 ? left - 1 : left + 1]));
    }
}
