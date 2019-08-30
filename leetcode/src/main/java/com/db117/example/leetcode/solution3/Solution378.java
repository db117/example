package com.db117.example.leetcode.solution3;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * <p>
 * 示例:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/30/030
 */
public class Solution378 {
    //[[1,1,3,8,13],[4,4,4,8,18],[9,14,18,19,20],[14,19,23,25,25],[18,21,26,28,29]]
    //13
    public static void main(String[] args) {
        System.out.println(new Solution378().kthSmallest(new int[][]{
                new int[]{1, 1, 3, 8, 13},
                new int[]{4, 4, 4, 8, 18},
                new int[]{9, 14, 18, 19, 20},
                new int[]{14, 19, 23, 25, 25},
                new int[]{18, 21, 26, 28, 29}
        }, 2));
    }

    public int kthSmallest(int[][] matrix, int k) {
        // 二分
        int len = matrix.length;
        int left = matrix[0][0], right = matrix[len - 1][len - 1];

        while (left < right) {
            int count = 0;
            int mid = left + ((right - left) >> 1);

            // 计算比中间值
            for (int[] ints : matrix) {
                count += bs(ints, mid);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 小于等于目标值的个数
    public int bs(int[] data, int target) {
        int left = 0, right = data.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int num = data[mid];
            if (num > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
