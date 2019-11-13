package com.db117.example.leetcode.solution4;

/**
 * 453. 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/13/013 14:07
 */
public class Solution453 {
    public static void main(String[] args) {
        System.out.println(new Solution453().minMoves(new int[]{
                1, 2, 3
        }));
    }

    public int minMoves(int[] nums) {
        // n-1 增加 即为只有一个减
        // 找到最小值,求所以数字与最小值之差的和
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            sum += (num - min);
        }
        return sum;
    }
}
