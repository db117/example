//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 94 👎 0


package com.db117.example.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 10.01.合并排序的数组.sorted-merge-lcci
 *
 * @author db117
 * @since 2021-01-19 15:47:03
 **/

public class Interview_1001 {
    public static void main(String[] args) {
        Solution solution = new Interview_1001().new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        solution.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int index = A.length - 1;
            m -= 1;
            n -= 1;
            while (m >= 0 || n >= 0) {
                if (m < 0) {
                    // A已经取完了
                    A[index--] = B[n--];
                    continue;
                }
                if (n < 0) {
                    A[index--] = A[m--];
                    continue;
                }

                // 找最大的那个
                if (A[m] > B[n]) {
                    A[index--] = A[m--];
                } else {
                    A[index--] = B[n--];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}