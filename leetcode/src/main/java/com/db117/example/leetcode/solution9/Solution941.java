package com.db117.example.leetcode.solution9;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/19/019 16:59
 */
public class Solution941 {
    public static void main(String[] args) {
        System.out.println(new Solution941().validMountainArray(new int[]{
                0, 1, 2, 3
        }));
    }

    public boolean validMountainArray(int[] A) {
        int[] arr = A;
        if (arr.length < 3) {
            return false;
        }

        // 找到最高点
        int max = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                max = i;
                break;
            }
        }

        // 如果没有找到,或者第一个就是
        if (max < 1) {
            return false;
        }

        // 是不是降序
        for (int i = max; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
