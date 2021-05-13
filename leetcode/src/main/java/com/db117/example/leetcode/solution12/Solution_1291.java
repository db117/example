

// 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 回溯算法 
// 👍 26 👎 0


package com.db117.example.leetcode.solution12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1291.顺次数.sequential-digits
 *
 * @author db117
 * @since 2021-05-13 17:19:40
 **/

public class Solution_1291 {
    public static void main(String[] args) {
        Solution solution = new Solution_1291().new Solution();
        System.out.println(solution.sequentialDigits(1000, 13000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> sequentialDigits(int low, int high) {
            ArrayList<Integer> ans = new ArrayList<>();
            // 第一个数字不能为0和9
            for (int i = 1; i < 9; i++) {
                int n = i;
                // 按循序进行累加
                for (int j = i + 1; j <= 9; j++) {
                    n *= 10;
                    n += j;


                    if (n > high) {
                        break;
                    }
                    if (n >= low) {
                        // 符合题目范围
                        ans.add(n);
                    }

                }
            }

            ans.sort(Comparator.naturalOrder());
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}