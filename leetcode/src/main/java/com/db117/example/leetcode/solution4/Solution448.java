package com.db117.example.leetcode.solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/12/012 14:49
 */
public class Solution448 {
    public static void main(String[] args) {
        System.out.println(new Solution448().findDisappearedNumbers(new int[]{
                1, 1
        }));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        // 数组索引
        int i = 0;
        // 遍历数字
        for (int j = 1; j < nums.length + 1; j++) {
            if (i >= nums.length) {
                // 解决数组最大的数组不存在的情况
                res.add(j);
                continue;
            }
            if (nums[i] != j) {
                // 不相等则当前数组没有存在
                res.add(j);
            }
            while (i < nums.length && nums[i] == j) {
                // 过滤相等数字
                i++;
            }
        }

        return res;
    }

}
