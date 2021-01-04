


//小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 `x` 和 `y`），请小扣说出计算指令：
//- `"A"` 运算：使 `x = 2 * x + y`；
//- `"B"` 运算：使 `y = 2 * y + x`。
//
//在本次游戏中，店家说出的数字为 `x = 1` 和 `y = 0`，小扣说出的计算指令记作仅由大写字母 `A`、`B` 组成的字符串 `s`，字符串中字符的
//顺序表示计算顺序，请返回最终 `x` 与 `y` 的和为多少。
//
//**示例 1：**
//>输入：`s = "AB"`
//> 
//>输出：`4`
//> 
//>解释：
//>经过一次 A 运算后，x = 2, y = 0。
//>再经过一次 B 运算，x = 2, y = 2。
//>最终 x 与 y 之和为 4。
//
//**提示：**
//- `0 <= s.length <= 10`
//- `s` 由 `'A'` 和 `'B'` 组成
//
//
// 👍 11 👎 0


package com.db117.example.leetcode.lcp;

/**
 * LCP 17.速算机器人.nGK0Fy
 *
 * @author db117
 * @since 2021-01-04 18:50:12
 **/

public class LCP_17 {
    public static void main(String[] args) {
        Solution solution = new LCP_17().new Solution();
        System.out.println(solution.calculate(""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 不管说啥都是(x+y)*2
            return (int) Math.pow(2, s.length());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}