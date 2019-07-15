package com.db117.example.leetcode.solution1;

import lombok.extern.slf4j.Slf4j;

/**
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/15
 **/
@Slf4j
public class Solution137 {
    public int singleNumber(int[] nums) {
        // 保存每一位出现的次数
        int[] temp = new int[32];

        // 计算每一位出现的次数
        for (int num : nums) {
            int i = 1;
            int j = 31;
            while (j >= 0) {
                if ((num & i) != 0) {
                    temp[j]++;
                }
                j--;
                i <<= 1;
            }
        }
        int res = 0;
        // 把数组转换为数字
        // 数组中数字对3取模肯定不会大于1
        for (int i = 1, j = 31; j >= 0; i <<= 1, j--) {
            if (temp[j] % 3 != 0) {
                // 取模后不等于0,说明那个只出现1次的数字在该位上
                res |= i;
            }
        }
        return res;
    }
}
