package com.db117.example.leetcode.solution2;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/14/014
 */
public class Solution287 {
    public static void main(String[] args) {
        System.out.println(new Solution287().findDuplicate(new int[]{
                3, 1, 3, 4, 2
        }));
    }

    public int findDuplicate(int[] nums) {
        // 对值进行二分,不是对索引
        int left = 0, right = nums.length - 1;
        int count;
        while (left < right) {
            count = 0;
            int mid = (left + right) >>> 1;
            // 统计小于mid的个数
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 如果小于等于中位数的个数大于中位数则重复的数字肯定在1-mid
            if (count > mid) {
                right = mid;
            } else {
                // 根据题意,不会出现小于的情况,等于的话说明重复的数字大于mid
                left = mid + 1;
            }
        }
        return left;
    }


}
