// 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
//
// 
// S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母； 
// 子串 'aaa' 没有出现在 S 中； 
// 子串 'bbb' 没有出现在 S 中。 
// 
//
// 
//
// 示例 1： 
//
// 输入：A = 1, B = 2
//输出："abb"
//解释："abb", "bab" 和 "bba" 都是正确答案。
// 
//
// 示例 2： 
//
// 输入：A = 4, B = 1
//输出："aabaa" 
//
// 
//
// 提示： 
//
// 
// 0 <= A <= 100 
// 0 <= B <= 100 
// 对于给定的 A 和 B，保证存在满足要求的 S。 
// 
// Related Topics 贪心算法 
// 👍 53 👎 0


package com.db117.example.leetcode.solution9;

/**
 * 984.不含 AAA 或 BBB 的字符串.string-without-aaa-or-bbb
 *
 * @author db117
 * @since 2021-02-18 15:35:56
 **/

public class Solution_984 {
    public static void main(String[] args) {
        Solution solution = new Solution_984().new Solution();
        System.out.println(solution.strWithout3a3b(1, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String strWithout3a3b(int a, int b) {
            StringBuilder res = new StringBuilder();

            // 先放多的字符
            boolean curIsA = a > b;

            while (a > 0 || b > 0) {
                if (curIsA && a > 0) {
                    if (a > b && a > 1) {
                        // a比b多就多放a
                        res.append('a');
                        a--;
                    }
                    res.append('a');
                    a--;
                } else if (b > 0) {
                    if (b > a && b > 1) {
                        // b比a多就多放b
                        res.append('b');
                        b--;
                    }
                    res.append('b');
                    b--;
                }
                curIsA = !curIsA;
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}