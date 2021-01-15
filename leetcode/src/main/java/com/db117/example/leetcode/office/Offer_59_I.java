//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 168 👎 0


package com.db117.example.leetcode.office;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I.滑动窗口的最大值.hua-dong-chuang-kou-de-zui-da-zhi-lcof
 *
 * @author db117
 * @since 2021-01-15 14:57:56
 **/

public class Offer_59_I {
    public static void main(String[] args) {
        Solution solution = new Offer_59_I().new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[0];
            }

            int[] ans = new int[nums.length - k + 1];
            int index = 0;
            // 单调队列
            Deque<Integer> deque = new LinkedList<>();

            // 区间未闭合
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                // 保证队列中都比当前值大,并且保证非严格递减
                while (!deque.isEmpty() && deque.peekLast() < num) {
                    deque.removeLast();
                }
                deque.offerLast(num);
            }
            // 第一个区间的最大值
            ans[index++] = deque.peekFirst();

            // 区间闭合
            for (int i = k; i < nums.length; i++) {
                int num = nums[i];
                // 如果删除的那个数字是前面最大值
                if (nums[i - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }

                // 把当前值添加进队列,并保证队列中都不小于当前值
                while (!deque.isEmpty() && deque.peekLast() < num) {
                    deque.removeLast();
                }
                deque.offerLast(num);

                // 队列头就是当前区间最大值
                ans[index++] = deque.peekFirst();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}