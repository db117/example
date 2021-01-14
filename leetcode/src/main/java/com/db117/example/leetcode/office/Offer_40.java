//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 176 👎 0


package com.db117.example.leetcode.office;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40.最小的k个数.zui-xiao-de-kge-shu-lcof
 *
 * @author db117
 * @since 2021-01-13 19:00:44
 **/

public class Offer_40 {
    public static void main(String[] args) {
        Solution solution = new Offer_40().new Solution();

        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{
                0, 1, 2, 1
        }, 2)))
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (k >= arr.length) {
                return arr;
            }

            // 优先队列
            // 大顶堆
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());

            for (int j : arr) {
                if (queue.size() < k) {
                    queue.add(j);
                } else {
                    if (queue.peek() > j) {
                        // 扔掉最大的
                        queue.poll();
                        queue.offer(j);
                    }
                }
            }

            return queue.stream()
                    .mapToInt(o -> o)
                    .toArray();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}