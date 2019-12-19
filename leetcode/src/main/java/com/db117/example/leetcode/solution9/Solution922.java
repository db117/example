package com.db117.example.leetcode.solution9;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/19/019 15:51
 */
public class Solution922 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution922().sortArrayByParityII(new int[]{
                4, 2, 5, 7
        })));
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] arr = A;

        boolean flag = false;
        int even = 0, odd = 0, index = 0;
        while (index < arr.length) {
            if (flag) {
                // 找到下一个偶数
                while (odd < arr.length) {
                    if (arr[odd] % 2 != 0) {
                        break;
                    } else {
                        odd++;
                    }
                }
                // 交换并自增
                swap(arr, index++, odd++);
                flag = false;
            } else {
                while (even < arr.length) {
                    if (arr[even] % 2 == 0) {
                        break;
                    } else {
                        even++;
                    }
                }
                swap(arr, index++, even++);
                flag = true;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
