package com.db117.example.leetcode.solution9;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/13/013 15:10
 */
public class Solution977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[]{
                -7, -3, 2, 3, 11
        })));
    }

    public int[] sortedSquares(int[] A) {
        int[] arr = A;
        // 返回的数组
        int[] res = new int[arr.length];
        // 返回的数组的索引
        int index = res.length - 1;

        // 平方
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // 从左右开始找到最大的数
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (arr[left] > arr[right]) {
                res[index--] = arr[left];
                left++;
            } else {
                res[index--] = arr[right];
                right--;
            }
        }
        return res;
    }

    public int[] sortedSquares1(int[] A) {
        int[] arr = A;
        // 最小正数的位置
        int minPlus = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                minPlus = i;
                break;
            }
        }
        if (minPlus == -1) {
            // 没有正数
            // 平方后逆序
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int leftPow = arr[left] * arr[left];
                arr[left] = arr[right] * arr[right];
                arr[right] = leftPow;
                left++;
                right--;
            }
            return arr;
        }
        // 正数平方
        for (int i = minPlus; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        // 负数平方,并排序
        for (int i = 0; i < minPlus; i++) {
            // 数组的第一个数字
            int pow = arr[0] * arr[0];
            // 插入排序
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] < pow) {
                    System.arraycopy(arr, 1, arr, 0, j);
                    arr[j] = pow;
                    break;
                }
            }
        }
        return arr;
    }

}
