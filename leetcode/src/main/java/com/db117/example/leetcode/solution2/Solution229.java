package com.db117.example.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/19/019
 */
public class Solution229 {
    public static void main(String[] args) {
        System.out.println(new Solution229().majorityElement(new int[]{
                1, 2
        }));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int numA = nums[0], countA = 0, numB = nums[0], countB = 0;

        // 摩尔投票
        for (int num : nums) {
            if (num == numA) {
                countA++;
                continue;
            }
            if (num == numB) {
                countB++;
                continue;
            }

            // A为0,把b设为当前值
            if (countA == 0) {
                countA = 1;
                numA = num;
                continue;
            }

            // B为0,把b设为当前值
            if (countB == 0) {
                countB = 1;
                numB = num;
                continue;
            }

            // 都不为0
            countA--;
            countB--;
        }

        countA = 0;
        countB = 0;
        // 判断两个候选数字是否大于n/3
        for (int num : nums) {
            if (num == numA) {
                countA++;
            } else if (numB == num) {
                // 当a=b是不加B
                countB++;
            }
        }
        // 大于n/3添加到返回值
        int i = nums.length / 3;
        if (countA > i) {
            res.add(numA);
        }
        if (countB > i) {
            res.add(numB);
        }
        return res;
    }
}
