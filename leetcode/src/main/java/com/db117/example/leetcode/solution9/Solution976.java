package com.db117.example.leetcode.solution9;

/**
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/13/013 14:39
 */
public class Solution976 {
    public static void main(String[] args) {
        System.out.println(new Solution976().largestPerimeter(new int[]{
                2, 1, 2
        }));
    }

    public int largestPerimeter(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            // 冒泡排序
            for (int j = 0; j < len - i; j++) {
                if (j < len - 1 && A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }

            if (i > 1) {
                // 找到已经排好序的最小的三个数字,进行比较
                int index = len - i - 1;
                if (A[index] + A[index + 1] > A[index + 2]) {
                    return A[index] + A[index + 1] + A[index + 2];
                }
            }
        }
        return 0;
    }
}
