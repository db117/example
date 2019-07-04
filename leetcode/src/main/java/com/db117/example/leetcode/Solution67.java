package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/3
 **/
@Slf4j
public class Solution67 {
    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        int i1 = a.indexOf("1");
        int i2 = b.indexOf("1");
        if (i1 == -1) {
            // a为0
            return b;
        }
        if (i2 == -1) {
            // b为0
            return a;
        }

        // 去掉前面的0
        if (i1 != 0) {
            a = a.substring(i1);
        }
        if (i2 != 0) {
            b = b.substring(i2);
        }
        // 返回数组
        char[] res;
        res = new char[Math.max(a.length(), b.length()) + 1];

        boolean flag = false;
        i1 = a.length() - 1;
        i2 = b.length() - 1;
        for (int i = 0; i < res.length; i++) {
            // 和
            int temp = flag ? 1 : 0;
            if (i1 >= 0) {
                temp += (a.charAt(i1--) == '0' ? 0 : 1);
            }
            if (i2 >= 0) {
                temp += (b.charAt(i2--) == '0' ? 0 : 1);
            }

            // 需要进位
            if (temp > 1) {
                res[res.length - 1 - i] = (temp - 2 == 1 ? '1' : '0');
                flag = true;
            } else {
                // 不需要进位
                res[res.length - 1 - i] = (temp == 1 ? '1' : '0');
                flag = false;
            }
        }
        // 去掉开头的0
        String s = new String(res);
        return s.substring(s.indexOf("1"));
    }
}
