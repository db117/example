package com.db117.example.leetcode.solution9;

import java.util.HashSet;
import java.util.Set;

/**
 * 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/20/020 14:41
 */
public class Solution961 {
    public static void main(String[] args) {
        System.out.println(new Solution961().repeatedNTimes(new int[]{
                5, 1, 5, 2, 5, 3, 5, 4
        }));
    }

    public int repeatedNTimes(int[] A) {
        int[] arr = A;

        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.add(i)) {
                return i;
            }
        }

        return 0;
    }
}
