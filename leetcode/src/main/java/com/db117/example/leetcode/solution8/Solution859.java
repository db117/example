//给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标
// 0 和下标 2 的元素可以生成 "cbad" 。 
//
// 
//
// 示例 1： 
//
// 
//输入： A = "ab", B = "ba"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。 
//
// 示例 2： 
//
// 
//输入： A = "ab", B = "ab"
//输出： false
//解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
// 
//
// 示例 3: 
//
// 
//输入： A = "aa", B = "aa"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。 
//
// 示例 4： 
//
// 
//输入： A = "aaaaaaabc", B = "aaaaaaacb"
//输出： true
// 
//
// 示例 5： 
//
// 
//输入： A = "", B = "aa"
//输出： false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 20000 
// 0 <= B.length <= 20000 
// A 和 B 仅由小写字母构成。 
// 
// Related Topics 字符串 
// 👍 117 👎 0


package com.db117.example.leetcode.solution8;

/**
 * 859.亲密字符串.buddy-strings
 *
 * @author db117
 * @since 2020-11-06 10:51:16
 **/

public class Solution859 {
    public static void main(String[] args) {
        Solution solution = new Solution859().new Solution();
        System.out.println(solution.buddyStrings("dd", "dd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            StringBuilder a = new StringBuilder(A);
            StringBuilder b = new StringBuilder(B);

            // 记录字符出现的次数
            int[] tmp = new int[26];

            int len = a.length();
            for (int i = len - 1; i >= 0; i--) {
                char aC = a.charAt(i);
                char bC = b.charAt(i);

                tmp[aC - 'a']++;

                if (aC == bC) {
                    a.deleteCharAt(i);
                    b.deleteCharAt(i);
                }
            }

            // 有两个字符不一样,而且可以交换
            if (a.length() == 2 &&
                    a.charAt(0) == b.charAt(1) &&
                    a.charAt(1) == b.charAt(0)) {
                return true;
            }

            if (a.length() == 0) {
                // 当所有字符都一样,但是在一个字符串上有相同的字符
                for (int i : tmp) {
                    if (i > 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}