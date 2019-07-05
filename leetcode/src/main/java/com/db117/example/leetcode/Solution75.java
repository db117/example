package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/5
 **/
@Slf4j
public class Solution75 {
    public static void main(String[] args) {
        int[] ints = new int[]{
                0, 2, 1
        };
        new Solution75().sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sortColors(int[] nums) {
        // 0的右指针
        int left = 0;
        // 2的最左边指针
        int right = nums.length - 1;

        int index = 0;
        while (index <= right) {
            int num = nums[index];
            if (num == 0) {
                // 等于0,和0的最右边交换
                if (index != left) {
                    int temp = nums[left];
                    nums[left] = nums[index];
                    nums[index] = temp;
                }
                left++;
                index++;
            } else if (num == 2) {
                // 和2的最左边交换
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            } else {
                index++;
            }
        }
    }
}
