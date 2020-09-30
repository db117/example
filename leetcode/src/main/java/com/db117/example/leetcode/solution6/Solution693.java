//给定一个正整数，检查他是否为交替位二进制数：换句话说，
// 就是他的二进制数相邻的两个位数永不相等。
//
// 示例 1: 
//
// 
//输入: 5
//输出: True
//解释:
//5的二进制数是: 101
// 
//
// 示例 2: 
//
// 
//输入: 7
//输出: False
//解释:
//7的二进制数是: 111
// 
//
// 示例 3: 
//
// 
//输入: 11
//输出: False
//解释:
//11的二进制数是: 1011
// 
//
// 示例 4: 
//
// 
//输入: 10
//输出: True
//解释:
//10的二进制数是: 1010
// 
// Related Topics 位运算 
// 👍 77 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 693.交替位二进制数
 *
 * @author db117
 * @date 2020-09-23 14:10:13
 **/
public class Solution693 {
    public static void main(String[] args) {
        Solution solution = new Solution693().new Solution();
        System.out.println(solution.hasAlternatingBits(
                Integer.parseInt(
                        "101010101", 2
                )
//                Integer.MAX_VALUE
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAlternatingBits(int n) {
            // 是否为1
            boolean pre = (n & 1) == 1;
            for (int i = 1; i < 32; i++) {
                int k = 1 << i;
                // n最左边的1的位置
                if (k <= n) {
                    if (pre) {
                        // 前一位为1,则当前位为0
                        if ((k & n) != 0) {
                            return false;
                        }
                    } else {
                        // 前一位为0,则当前位为1
                        if ((k & n) == 0) {
                            return false;
                        }
                    }
                    pre = !pre;
                } else {
                    break;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}