//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 376 👎 0


package com.db117.example.leetcode.solution3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 321.拼接最大数.create-maximum-number
 *
 * @author db117
 * @since 2021-04-29 18:34:22
 **/

public class Solution_321 {
    public static void main(String[] args) {
        Solution solution = new Solution_321().new Solution();

        System.out.println(Arrays.toString(solution.maxNumber(new int[]{
                6, 7
        }, new int[]{
                6, 0, 4
        }, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {

            Deque<Integer> deque = new LinkedList<>();
            int[] ans = new int[k];

            for (int i = Math.max(k - nums2.length, 0);// 保证nums1的数量大于0
                 i <= k && i <= nums1.length;// 保证nums2的数量大于0
                 i++) {

                // 分别算一下
                int[] helper1 = helper(deque, nums1, i);
                int[] helper2 = helper(deque, nums2, k - i);

                // 和起来
                int[] marge = marge(helper1, helper2);

                if (ge(marge, 0, ans, 0)) {
                    ans = marge;
                }

            }
            return ans;
        }

        private int[] marge(int[] helper1, int[] helper2) {
            // 合并为最大的
            int[] ans = new int[helper1.length + helper2.length];

            int i = 0, j = 0, index = 0;
            while (i < helper1.length || j < helper2.length) {
                if (i >= helper1.length) {
                    ans[index++] = helper2[j++];
                    continue;
                }
                if (j >= helper2.length) {
                    ans[index++] = helper1[i++];
                    continue;
                }

                if (ge(helper1, i, helper2, j)) {
                    ans[index++] = helper1[i++];
                } else {
                    ans[index++] = helper2[j++];
                }
            }
            return ans;
        }

        // 比较两个数组
        private boolean ge(int[] helper1, int i, int[] helper2, int j) {

            // 想等就一直走下去
            while (i < helper1.length && j < helper2.length && helper1[i] == helper2[j]) {
                i++;
                j++;
            }
            if (i == helper1.length) {
                return false;
            }

            if (j == helper2.length) {
                return true;
            }

            return helper1[i] > helper2[j];
        }

        // 找到几个数字,使组成的数字最大
        // 单调递减栈
        private int[] helper(Deque<Integer> deque, int[] nums, int n) {
            deque.clear();
            // 需要删除的数字
            int rmNum = nums.length - n;
            for (int num : nums) {

                if (deque.isEmpty()) {
                    deque.offerFirst(num);
                    continue;
                }

                // 删除前面比当前数字小的数字
                while (!deque.isEmpty() &&
                        rmNum > 0 &&
                        deque.peekLast() < num) {
                    deque.pollLast();
                    rmNum--;
                }
                deque.offerLast(num);
            }
            while (deque.size() > n) {
                deque.pollLast();
            }

            return deque.stream().mapToInt(v -> v).toArray();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}