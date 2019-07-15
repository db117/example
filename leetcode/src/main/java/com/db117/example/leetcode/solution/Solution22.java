package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/10
 **/
@Slf4j
public class Solution22 {
    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis1(3));
    }

    /**
     * 回溯
     * 看题解的
     *
     * @param n 还有几对括号
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            // 当为0时不添加括号
            ans.add("");
        } else {
            for (int i = n - 1; i >= 0; i--) {
                // 获取剩余几对括号的全部可能性
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - i - 1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        gen(res, n, new char[0], 0, 0);
        return res;
    }

    /**
     * 生成括号
     *
     * @param res   返回值
     * @param n     一共有多少括号
     * @param chars 当前字节数组
     * @param left  左括号使用数量
     * @param right 右括号使用数量
     */
    public void gen(List<String> res, int n, char[] chars, int left, int right) {
        // 组合完成
        if (left == n && right == n) {
            res.add(new String(chars));
            return;
        }

        // 创建数组
        char[] desc = new char[chars.length + 1];
        if (left < n) {
            // 还有左括号没有填
            desc[chars.length] = '(';
            System.arraycopy(chars, 0, desc, 0, chars.length);
            // 递归调用直到全部填完
            gen(res, n, desc, left + 1, right);
        }
        if (right < left) {
            // 还有右括号
            desc[chars.length] = ')';
            System.arraycopy(chars, 0, desc, 0, chars.length);
            gen(res, n, desc, left, right + 1);
        }

    }
}
