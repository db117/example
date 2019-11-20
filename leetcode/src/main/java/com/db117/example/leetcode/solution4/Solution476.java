package com.db117.example.leetcode.solution4;

/**
 * 476. 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/20/020 15:49
 */
public class Solution476 {
    public static void main(String[] args) {
        System.out.println(new Solution476().findComplement1(1));
    }

    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (!flag && chars[i] == '1') {
                // 过滤前导0
                flag = true;
            }

            if (flag) {
                chars[i] = chars[i] == '1' ? '0' : '1';
            }
        }
        return Integer.parseInt(new String(chars), 2);
    }

    public int findComplement1(int num) {
        // 5->2          101
        // 只保留第一个1  100
        // 左移          1000
        // 减一          111
        // 异或          101 ^ 111 = 10
        return ((Integer.highestOneBit(num) << 1) - 1) ^ num;
    }
}
