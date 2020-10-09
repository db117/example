//有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
//
// 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。 
//
// 示例 1: 
//
// 
//输入: 
//bits = [1, 0, 0]
//输出: True
//解释: 
//唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入: 
//bits = [1, 1, 1, 0]
//输出: False
//解释: 
//唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
// 
//
// 注意: 
//
// 
// 1 <= len(bits) <= 1000. 
// bits[i] 总是0 或 1. 
// 
// Related Topics 数组 
// 👍 149 👎 0

package com.db117.example.leetcode.solution7;

/**
 * 717.1比特与2比特字符.1-bit-and-2-bit-characters
 *
 * @author db117
 * @date 2020-09-30 17:22:20
 **/
public class Solution717 {
    public static void main(String[] args) {
        Solution solution = new Solution717().new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{
                1, 0, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            if (bits.length == 1) {
                return true;
            }
            // 是否必定为一个一比特字符,取决于租后一个0前面有几个1
            int count = 0;
            for (int i = bits.length - 2; i >= 0; i--) {
                if (bits[i] == 1) {
                    count++;
                } else {
                    break;
                }
            }

            return count % 2 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}