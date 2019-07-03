package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * <p>
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/2
 **/
@Slf4j
public class Solution65 {
    public static void main(String[] args) {
        System.out.println(new Solution65().isNumber(" .-4"));
    }

    public boolean isNumber(String s) {
        // 恶心
        if (s == null) {
            return false;
        }
        // 跳空
        s = s.trim();
        if (s.isEmpty() || ".".equals(s)) {
            return false;
        }
        // 是否有e
        boolean eFlag = true;
        // 是否可以有符号
        boolean preFlag = true;
        // 是否可以有点(.)
        boolean pointFlag = true;
        // 是否必须是数字
        boolean isNum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (isNum) {
                    // 数字后边可以跟数字
                    isNum = false;
                }
                // 是数字
                // 不能有-+
                preFlag = false;
                continue;
            }
            if (isNum) {
                if (s.charAt(i - 1) == '.') {
                    return false;
                }
                if (c == '-' || c == '+') {
                    preFlag = false;
                    continue;
                }
                // -+e后面必须是数字
                return false;
            }

            if (c == '-' || c == '+') {
                // 判断符号是否合法
                if (!preFlag) {
                    return false;
                }
                // 不能有-+
                preFlag = false;
                continue;
            }

            if (c == '.') {
                // 判断.是否合法
                if (!pointFlag) {
                    return false;
                }
                // 如果前面没有数字.后面必须有数字
                if (i == 0 || s.charAt(i - 1) < '0' || s.charAt(i - 1) > '9') {
                    isNum = true;
                }
                // 后面不能有.
                pointFlag = false;
                // 不能有-+
                preFlag = false;
                continue;
            }

            if (c == 'e') {
                // 判断e是否合法
                if (!eFlag) {
                    return false;
                }
                // 可以有-+
                preFlag = true;
                // e不能出现在首位
                if (i == 0 || i == s.length() - 1) {
                    return false;
                }
                // e前面必须是数字
                char temp = s.charAt(i - 1);
                if (temp < '0' || temp > '9') {
                    if (temp != '.') {
                        return false;
                    }
                }
                // 不能再有e
                eFlag = false;
                // 后面必须是数字
                isNum = true;
                // 不能有.
                pointFlag = false;
                continue;
            }
            // 其他字符
            return false;
        }
        // -+e不能是最后一个
        return !isNum;
    }
}
