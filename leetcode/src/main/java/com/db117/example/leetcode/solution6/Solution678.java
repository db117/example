package com.db117.example.leetcode.solution6;

import lombok.extern.slf4j.Slf4j;

/**
 * 678. 有效的括号字符串
 * <p>
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * <p>
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * 注意:
 * <p>
 * 字符串大小将在 [1，100] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/24/024
 **/
@Slf4j
public class Solution678 {
    public static void main(String[] args) {
        System.out.println(new Solution678().checkValidString("(()"));
    }

    public boolean checkValidString(String s) {
        if ("".equals(s)) {
            return true;
        }
        // *作为左,右扩后时左括号的数量
        int left = 0, right = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    // 左括号的数量都加
                    left++;
                    right++;
                    break;
                case '*':
                    left++;
                    if (right > 0) {
                        right--;
                    }
                    break;
                case ')':
                    left--;
                    if (right > 0) {
                        right--;
                    }
                    break;
                default:
            }

            // 当把*都当做左括号,左括号都不够用的话就不是有效的
            if (left < 0) {
                return false;
            }
        }
        // 把*都当右括号能不能把左括号消耗完
        return right == 0;
    }
}
