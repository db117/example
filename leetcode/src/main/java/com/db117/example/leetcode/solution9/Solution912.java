package com.db117.example.leetcode.solution9;

import java.util.Arrays;

/**
 * 912. 排序数组
 * 给定一个整数数组 nums，将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -50000 <= A[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/12/012
 */
public class Solution912 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution912().sortArray(new int[]{
                -2, 3, -5
        })));
    }

    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    /**
     * 堆排序
     */
    public int[] heapSort(int[] data) {
        // 构建最大堆
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjustHeap(data, i, data.length);
        }

        // 把最大值移动到数组尾部
        for (int i = data.length - 1; i > 0; i--) {
            // 把构建完的最大堆的堆顶,放入已经排完序的前面
            swap(data, 0, i);

            // 对前面的进行构建
            adjustHeap(data, 0, i);
        }

        return data;
    }

    /**
     * 构建堆
     */
    public void adjustHeap(int[] data, int top, int len) {
        for (int i = 2 * top + 1; i < len; i = 2 * i + 1) {
            // 保证i为改变的子节点,即是i为最大的子节点索引
            if (i + 1 < len && data[i] < data[i + 1]) {
                // 如果左节点小于右节点则把i边为右节点索引
                i++;
            }

            // 子节点大于堆顶
            if (data[i] > data[top]) {
                // 如果子节点大于父节点,交换
                swap(data, i, top);

                // 下一个堆顶为改变的子节点
                top = i;
            } else {
                // 如果堆顶就是最大的,则结束
                break;
            }
        }
    }

    /**
     * 交换数组
     */
    public void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
}
