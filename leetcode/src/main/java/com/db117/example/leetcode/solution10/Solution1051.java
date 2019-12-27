package com.db117.example.leetcode.solution10;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/27/027 14:59
 */
public class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();
        Arrays.sort(clone);

        int ans = 0;
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}
