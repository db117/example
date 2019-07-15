package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/20
 **/
@Slf4j
public class Solution42 {
    public static void main(String[] args) {
        System.out.println(new Solution42().trap2(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    public int trap2(int[] height) {
        int res = 0;
        // 左边最高的
        int[] leftMax = new int[height.length];
        // 右边最高的
        int[] rightMax = new int[height.length];

        // 找出所有左边最高的
        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        // 找出所以右边最好的
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        // 计算盛水量
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < min) {
                res += (min - height[i]);
            }
        }
        return res;
    }

    public int trap(int[] height) {
        int res = 0;
        // 最大值
        int max = max(height);
        for (int i = 1; i <= max; i++) {
            int index = 0;
            int temp = 0;
            while (index < height.length) {
                // 跳过没有水的位置
                if (height[index] < i) {
                    index++;
                    continue;
                }
                // 跳过没有水的位置
                while (index < height.length && height[index] >= i) {
                    index++;
                }
                // 找到有水的位置
                while (index < height.length && height[index] < i) {
                    temp++;
                    index++;
                }
                // 最后都没有找到比i大的,说明不能盛水
                if (index != height.length) {
                    res += temp;
                }
                temp = 0;
            }
        }
        return res;
    }

    int max(int[] height) {
        int max = 0;
        for (int i : height) {
            max = Math.max(max, i);
        }
        return max;
    }
}
