// 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 223 👎 0


package com.db117.example.leetcode.solution8;

import java.util.ArrayList;
import java.util.List;

/**
 * 842.将数组拆分成斐波那契序列.split-array-into-fibonacci-sequence
 *
 * @author db117
 * @since 2021-05-10 10:53:31
 **/

public class Solution_842 {
    public static void main(String[] args) {
        Solution solution = new Solution_842().new Solution();
        System.out.println(solution.splitIntoFibonacci("123456579"));
        System.out.println(solution.splitIntoFibonacci("11235813"));
        System.out.println(solution.splitIntoFibonacci("112358130"));
        System.out.println(solution.splitIntoFibonacci("0123"));
        System.out.println(solution.splitIntoFibonacci("1101111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> ans = new ArrayList<>();
            dfs(S.toCharArray(), ans, 0);
            return ans;
        }

        private boolean dfs(char[] chars, List<Integer> ans, int index) {
            int size = ans.size();
            // 都拆完了,而且数量至少三个
            if (index == chars.length && size > 2) {
                return true;
            }

            // 一直试到有满足的为止
            for (int i = index; i < chars.length; i++) {
                // 不能以0开头
                if (i > index && chars[index] == '0') {
                    return false;
                }

                // 当前数字
                long cur = helper(chars, index, i);

                // 当前数字不能大于Integer最大值
                if (cur >= Integer.MAX_VALUE) {
                    break;
                }
                // 当前数字大于前面两数字和,直接GG
                if (size > 1 && ans.get(size - 1) + ans.get(size - 2) < cur) {
                    break;
                }

                if (size > 1 && ans.get(size - 1) + ans.get(size - 2) > cur) {
                    continue;
                }

                // 到这来说明
                // 前面不够2个数字 或者  前面两个数字的和等于当前数字
                ans.add((int) cur);

                // 后面都符合
                if (dfs(chars, ans, i + 1)) {
                    return true;
                }

                // 回溯
                // 后面不符合删除刚才添加的数字
                ans.remove(size);
            }

            return false;
        }


        private long helper(char[] chars, int start, int end) {
            int ans = 0;
            for (int i = start; i <= end; i++) {
                ans *= 10;
                ans += chars[i] - '0';
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}