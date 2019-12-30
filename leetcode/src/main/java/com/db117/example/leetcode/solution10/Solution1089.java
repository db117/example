package com.db117.example.leetcode.solution10;

import java.util.Arrays;

/**
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/29/029 15:18
 */
public class Solution1089 {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 5, 2, 0, 6, 8, 0, 6, 0
//                1, 0, 2, 3, 0, 0, 5, 0
        };
        new Solution1089().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void duplicateZeros(int[] arr) {
        int zero = 0;
        // 最后一个存在的数字索引
        int last = 0;
        for (; last < arr.length - zero; last++) {
            if (arr[last] == 0) {
                zero++;
            }
        }

        if (zero == 0) {
            // 没有0
            return;
        }

        // 从右边充填数组
        int right = arr.length - 1;
        for (int j = last - 1; j >= 0 && right >= 0; j--) {
            if (arr[j] != 0) {
                arr[right--] = arr[j];
            } else {
                // 当删除的数字个数小于0的个数
                // 最后一个数字是0只写一次
                if (last - 1 == j && arr[j] == 0 && arr.length - last != zero) {
                    arr[right--] = 0;
                } else {
                    arr[right--] = 0;
                    arr[right--] = 0;
                }
            }
        }
    }
}
