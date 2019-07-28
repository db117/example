package com.db117.example.leetcode.solution7;

/**
 * 779. 第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * <p>
 * 例子:
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * 注意：
 * <p>
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/28/028
 **/
public class Solution779 {
    public static void main(String[] args) {
        System.out.println(new Solution779().kthGrammar(2, 2));
    }

    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) {
            return 0;
        }
        // 找到上一级
        int i = kthGrammar(n - 1, (k + 1) / 2);

        // 按照规律,奇数跟上级一样
        return k % 2 == 0 ? 1 - i : i;
    }
}
