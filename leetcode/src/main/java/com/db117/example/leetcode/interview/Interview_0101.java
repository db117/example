


//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 74 👎 0


package com.db117.example.leetcode.interview;

/**
 * 面试题 01.01.判定字符是否唯一.is-unique-lcci
 *
 * @author db117
 * @since 2021-01-07 17:17:24
 **/

public class Interview_0101 {
    public static void main(String[] args) {
        Solution solution = new Interview_0101().new Solution();
        System.out.println(solution.isUnique("abca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            for (int i = 0; i < astr.length(); i++) {
                if (astr.lastIndexOf(astr.charAt(i)) != i) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}