package com.db117.example.leetcode.solution10;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/12/012 17:12
 */
public class Solution1005 {
    public static void main(String[] args) {
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int sum = Arrays.stream(A).sum();
        if (A[0] == 0) {
            // 最小的数字为0
            return sum;
        }
        // 都是正数则判断k
        if (A[0] > 0) {
            if (K % 2 == 0) {
                return sum;
            } else {
                return sum - 2 * A[0];
            }
        }

        // 循环找到最小的数字进行处理
        for (int i = 0; i < K; i++) {
            Arrays.sort(A);
            int temp = -A[0];
            A[0] = temp;
        }
        return Arrays.stream(A).sum();
    }

}
