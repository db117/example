


//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 199 👎 0


package com.db117.example.leetcode.office;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II.和为s的连续正数序列.he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 *
 * @author db117
 * @since 2021-01-14 15:25:11
 **/

public class Offer_57_II {
    public static void main(String[] args) {
        Solution solution = new Offer_57_II().new Solution();
        System.out.println(Arrays.deepToString(solution.findContinuousSequence(
                75
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target < 3) {
                return new int[0][0];
            }
            List<int[]> ans = new ArrayList<>();
            // 双指针
            int left = 1, right = 2, sum = 3;
            while (right < target) {
                if (sum == target) {
                    int[] tmp = new int[right - left + 1];
                    for (int i = 0; i < tmp.length; i++) {
                        tmp[i] += left + i;
                    }

                    ans.add(tmp);
                    // 左边界右移
                    sum -= left;
                    left++;
                } else if (sum < target) {
                    // 右边界右移
                    right++;
                    sum += right;
                } else {
                    // 以当前的左边界开始是不可能有符合条件的子数组了
                    sum -= left;
                    left++;
                }
            }
            return ans.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public int[][] findContinuousSequence(int target) {
            if (target < 3) {
                return new int[0][0];
            }
            List<int[]> ans = new ArrayList<>();
            int[] tmp;
            for (int i = 2; i * 2 <= target; i++) {
                if (i % 2 == 1) {
                    if (target % i == 0) {
                        // 拆分成奇数个数字
                        tmp = new int[i];
                        // 中间的数字
                        int mid = target / i;
                        // 数字开始的数字
                        int start = mid - (i / 2);
                        if (start <= 0) {
                            // 防止出现从0开始的
                            continue;
                        }
                        for (int j = 0; j < tmp.length; j++) {
                            tmp[j] = start + j;
                        }
                        ans.add(tmp);

                        // 拆分成i*2个数字
                        if ((target / i) % 2 == 1) {
                            tmp = new int[2 * i];

                            // 数字开始的数字
                            start = (target / (2 * i)) - i + 1;
                            if (start <= 0) {
                                // 防止出现从0开始的
                                continue;
                            }
                            for (int j = 0; j < tmp.length; j++) {
                                tmp[j] = start + j;
                            }
                            ans.add(tmp);
                        }
                    }


                } else {
                    // 拆分成偶数个
                    // 100/4=25
                    // 25%2==1  25/2=12
                    // 9,10,11,12,13,14,15,16
                    if (target % i == 0 &&
                            /*偶数拆不开,只能拆奇数*/
                            (target / i) % 2 == 1) {

                        tmp = new int[i * 2];

                        // 开始的数字
                        int start = target / (i * 2) - i + 1;
                        if (start <= 0) {
                            // 防止出现从0开始的
                            continue;
                        }

                        for (int j = 0; j < tmp.length; j++) {
                            tmp[j] = start + j;
                        }
                        ans.add(tmp);
                    }

                }
            }
            // 奇数都可以拆成两个
            if (target % 2 == 1) {
                ans.add(new int[]{target / 2, target / 2 + 1});
            }
            // 排好序
            ans.sort((o1, o2) -> o2.length - o1.length);
            return ans.toArray(new int[0][0]);
        }
    }
}