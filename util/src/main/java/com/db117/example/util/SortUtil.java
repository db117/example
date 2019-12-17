package com.db117.example.util;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * @author db117
 * @date 2019/12/16/016 15:38
 */
public class SortUtil {
    public static void main(String[] args) {
        int len = 10000000;
        int[] arr = new int[len];
        Arrays.setAll(arr, operand -> RandomUtil.randomInt());

        SortUtil sortUtil = new SortUtil();
        long start = System.currentTimeMillis();

//        Arrays.sort(arr);
//        sortUtil.fastSort(arr, 0, arr.length - 1);
        sortUtil.margeSort(arr, 0, arr.length - 1);

        System.out.println(System.currentTimeMillis() - start);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("有问题");
                break;
            }
        }
    }

    private void margeSort(int[] arr, int start, int end) {
        if (start >= end) {
            // 递归结束
            return;
        }

        int mid = start + (end - start) / 2;

        // 从下到上进行排序
        margeSort(arr, start, mid);
        margeSort(arr, mid + 1, end);

        margeSortHelper(arr, start, end);
    }

    private void margeSortHelper(int[] arr, int start, int end) {
        // 拆分数组
        int mid = start + (end - start) / 2;

        // 临时数组
        int len = end - start + 1;
        int[] temp = new int[len];

        // 临时数组索引
        int i = 0;
        // 两个数组的索引
        int j = start;
        int k = mid + 1;

        while (i <= end) {
            // 第一个区间没有了
            if (j > mid) {
                while (i < len) {
                    temp[i++] = arr[k++];
                }
                break;
            }

            // 第二个区间没有了
            if (k > end) {
                while (i < len) {
                    temp[i++] = arr[j++];
                }
                break;
            }

            // 找到最小的值放入缓存数组中
            if (arr[j] < arr[k]) {
                temp[i++] = arr[j++];
            } else {
                temp[i++] = arr[k++];
            }
        }

        // copy数组
        System.arraycopy(temp, 0, arr, start, len);
    }


    /**
     * 快排
     */
    private void fastSort(int[] arr, int start, int end) {
        if (start >= end) {
            // 递归结束
            return;
        }

        // 排序,并返回中间索引
        int i = fastSortHelper(arr, start, end);

        // 根据中间索引拆分继续排序
        fastSort(arr, start, i - 1);
        fastSort(arr, i + 1, end);
    }

    private int fastSortHelper(int[] arr, int start, int end) {
        // 以最后一个数为基准
        int point = arr[end];
        // 下一个比基准小的数字放的位置
        int left = start;
        // 未分好的索引
        int right = start;
        while (right <= end) {
            // 把比基准小的放到前面
            if (arr[right] < point) {
                swap(arr, left, right);
                left++;
                right++;
            } else {
                right++;
            }
        }
        // 把基准放到left位置
        swap(arr, left, end);
        return left;
    }

    // 交换
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
