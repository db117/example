package com.db117.example.leetcode.solution;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author db117
 * @date 2019/5/19
 **/

public class Solution6 {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (length == 0 || numRows <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 列数
        int list = (length / (2 * numRows - 2)) * (numRows - 1);
        if (length > (2 * numRows - 2)) {
            int y = length % (2 * numRows - 2);
            if (y > 0 && y <= numRows) {
                list++;
            } else if (y != 0) {
                list = list + y - numRows + 1;
            }
        } else {
            list = Math.max(1, 1 + length - numRows);
        }

        // 二维数组保存数据
        char[][] data = new char[list][numRows];

        int index = 0;
        for (int i = 0; i < list; i++) {
            for (int j = 0; j < numRows; j++) {
                if (index == length) {
                    break;
                }
                int temp = i % (numRows - 1);
                if (temp == 0) {
                    // 满的列
                    data[i][j] = chars[index++];
                } else {
                    if (numRows - temp - 1 == j) {
                        data[i][j] = chars[index++];
                    }
                }
            }
        }
        // 组装返回
        index = 0;
        char[] res = new char[length];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < list; j++) {
                if (data[j][i] != '\u0000') {
                    res[index++] = data[j][i];
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 5));
    }
}
