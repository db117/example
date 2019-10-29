package com.db117.example.leetcode.solution4;

/**
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/28/028 15:42
 */
public class Solution414 {
    public static void main(String[] args) {
        System.out.println(new Solution414().thirdMax(new int[]{
                1, 2
        }));
    }

    public int thirdMax(int[] nums) {
        long[] max = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};


        for (int num : nums) {
            if (num > max[2]) {
                // 比第三个数字大
                if (num == max[1] || num == max[0]) {
                    continue;
                }
                if (num > max[1]) {
                    // 比第二个数字大
                    if (num > max[0]) {
                        // 比第一个数字还大
                        max[2] = max[1];
                        max[1] = max[0];
                        max[0] = num;
                        continue;
                    }
                    max[2] = max[1];
                    max[1] = num;
                    continue;
                }
                max[2] = num;
            }
        }
        // 如果没有第三大的则选第一
        return (int) (max[2] == Long.MIN_VALUE ? max[0] : max[2]);

    }
}
