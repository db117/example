package com.db117.example.leetcode.solution10;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/26/026
 **/
public class Solution1004 {
    public static void main(String[] args) {
        System.out.println(new Solution1004().longestOnes(new int[]{
                1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0
        }, 2));
    }

    public int longestOnes(int[] A, int K) {
        // 滑动窗口
        int left = 0, right = 0, count = 0, max = 0;

        while (right < A.length) {
            if (A[right] == 1) {
                count++;
            }
            // 窗口太大,左指针右移
            if (right - left + 1 - count > K) {
                if (A[left] == 1) {
                    // 左指针为1,计数减一
                    count--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
