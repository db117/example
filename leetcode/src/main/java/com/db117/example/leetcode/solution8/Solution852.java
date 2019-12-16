package com.db117.example.leetcode.solution8;

/**
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/16/016 14:16
 */
public class Solution852 {
    public static void main(String[] args) {
        System.out.println(new Solution852().peakIndexInMountainArray(new int[]{
                0, 2, 1, 0
        }));
    }

    public int peakIndexInMountainArray(int[] A) {
        int[] arr = A;

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 找到比前一个值大的最大值
            if (arr[mid] < arr[mid + 1]) {
                left++;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int peakIndexInMountainArray1(int[] A) {
        // 既然A是山脉数组,则最大值就是顶峰
        int ans = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                ans = i;
            }
        }
        return ans;
    }
}
