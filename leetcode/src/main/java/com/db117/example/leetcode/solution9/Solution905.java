package com.db117.example.leetcode.solution9;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/17/017 15:54
 */
public class Solution905 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution905().sortArrayByParity(new int[]{
                3, 1, 2, 4
        })));
    }

    public int[] sortArrayByParity(int[] A) {
        int[] arr = A;
        int left = 0, right = 0;
        while (right < arr.length) {
            if (arr[right] % 2 == 0) {
                // 把偶数放在前面
                swap(arr, left, right);
                left++;
            }
            right++;
        }
        return arr;
    }

    // 交换
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
