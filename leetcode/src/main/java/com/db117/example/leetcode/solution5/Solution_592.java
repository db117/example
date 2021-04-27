//给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，
//你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。 
//
// 示例 1: 
//
// 
//输入:"-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入:"-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入:"1/3-1/2"
//输出: "-1/6"
// 
//
// 示例 4: 
//
// 
//输入:"5/3+1/3"
//输出: "2/1"
// 
//
// 说明: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学 
// 👍 42 👎 0


package com.db117.example.leetcode.solution5;

/**
 * 592.分数加减运算.fraction-addition-and-subtraction
 *
 * @author db117
 * @since 2021-04-27 14:51:03
 **/

public class Solution_592 {
    public static void main(String[] args) {
        Solution solution = new Solution_592().new Solution();

//        System.out.println(solution.fractionAddition("-1/2+1/2"));
//        System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));
//        System.out.println(solution.fractionAddition("1/3-1/2"));
//        System.out.println(solution.fractionAddition("5/3+1/3"));
//        System.out.println(solution.fractionAddition("-5/2+10/3+7/9"));
        System.out.println(solution.fractionAddition("7/3+5/2-3/10"));
        // "7/3+5/2-3/10" 测试结果:"11/6" 期望结果:"68/15"
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            // 弄整齐一点
            if (expression.charAt(0) != '-') {
                expression = '+' + expression;
            }

            char[] chars = expression.toCharArray();

            // 求所有的分母的最小公倍数
            int min = 1;
            for (int i = 2; i < chars.length; i++) {
                char c = chars[i];
                if (c == '/') {
                    int n = chars[i + 1] - '0';
                    if (i + 2 < chars.length && chars[i + 2] == '0') {
                        // 处理分母为10
                        n = 10;
                    }
                    if (min % n != 0) {
                        min *= n;
                    }
                }

            }

            // 所有分子的和
            int sum = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '/') {

                    int symbol;
                    int up;
                    int down;

                    if (chars[i - 2] == '1') {
                        // 分子为10
                        symbol = chars[i - 3] == '+' ? 1 : -1;
                        up = 10;
                    } else {
                        symbol = chars[i - 2] == '+' ? 1 : -1;
                        up = chars[i - 1] - '0';
                    }

                    if (i + 2 < chars.length && chars[i + 2] == '0') {
                        // 分母为10
                        down = 10;
                    } else {
                        down = chars[i + 1] - '0';
                    }
                    // 符号*分子*分母最小公倍数/分母
                    sum += symbol * up * min / down;

                }
            }

            int gcd = gcd(Math.abs(sum), min);

            return String.valueOf(sum / gcd) + '/' + min / gcd;
        }

        // 两个数的最大公约数
        private int gcd(int m, int n) {
            if (n == 0) {
                return m;
            }
            return gcd(n, m % n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}