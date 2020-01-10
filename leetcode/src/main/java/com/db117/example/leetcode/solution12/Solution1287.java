package com.db117.example.leetcode.solution12;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/1/6/006 18:26
 */
public class Solution1287 {
    public static void main(String[] args) {
        System.out.println(new Solution1287().findSpecialInteger(new int[]{
                1, 2, 3, 3
        }));
    }

    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int n = length / 4;

        if (n < 1) {
            // 长度小于4 则所有值都满足
            return arr[0];
        }
        boolean flag = length % 4 == 0;
        // 长度是4的倍数
        n = length % 4 == 0 ? n : n + 1;

        int total = 1;
        int cur = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] == cur) {
                total++;
                if (total > n) {
                    return cur;
                }
            } else {
                cur = arr[i];
                total = 1;
            }
        }
        return -1;
    }
}
