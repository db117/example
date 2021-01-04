//请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解
//析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字
//符串。 
//
// 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。 
//
// 
//
// 示例 1： 
//
// 输入：command = "G()(al)"
//输出："Goal"
//解释：Goal 解析器解释命令的步骤如下所示：
//G -> G
//() -> o
//(al) -> al
//最后连接得到的结果是 "Goal"
// 
//
// 示例 2： 
//
// 输入：command = "G()()()()(al)"
//输出："Gooooal"
// 
//
// 示例 3： 
//
// 输入：command = "(al)G(al)()()G"
//输出："alGalooG"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= command.length <= 100 
// command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成 
// 
// Related Topics 字符串 
// 👍 11 👎 0


package com.db117.example.leetcode.solution16;

/**
 * 1678.设计 Goal 解析器.goal-parser-interpretation
 *
 * @author db117
 * @since 2021-01-04 15:14:20
 **/

public class Solution1678 {
    public static void main(String[] args) {
        Solution solution = new Solution1678().new Solution();
        System.out.println(solution.interpret("G()()()()(al)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String interpret(String command) {
            StringBuilder res = new StringBuilder();
            char[] chars = command.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == 'G') {
                    res.append('G');
                } else if (c == '(') {
                    if (chars[i + 1] == ')') {
                        res.append('o');
                        i++;
                    } else {
                        res.append("al");
                        i += 3;
                    }
                }
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}