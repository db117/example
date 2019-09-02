package com.db117.example.leetcode.solution2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/9/2/002
 */
public class Solution239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(new int[]{
                1, 3, -1, -3, 5, 3, 6, 7
        }, 6)));
    }

    private int[] nums;
    private Deque<Integer> deque = new LinkedList<>();
    private int k;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0) {
            return nums;
        }
        if (k == 1) {
            // 特殊处理
            return nums;
        }
        this.nums = nums;
        this.k = k;
        // 初始化前k个数字
        for (int i = 0; i < k; i++) {
            clear(i);
            deque.addLast(i);
        }

        // 初始化返回
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.peekFirst()];

        // 没一位进行一次处理
        for (int i = k; i < nums.length; i++) {
            clear(i);
            deque.addLast(i);
            // 获取最大值
            res[i - k + 1] = nums[deque.peekFirst()];
        }

        return res;
    }

    public void clear(int index) {
        // 清除区间外的数
        while (!deque.isEmpty() && deque.peekFirst() < index + 1 - k) {
            deque.pollFirst();
        }

        // 删除小于当前数的数字
        // 从后面开始清除,左边的肯定比有的大
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[index]) {
            deque.pollLast();
        }
    }

}