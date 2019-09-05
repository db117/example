package com.db117.example.leetcode.solution1;

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/4/004 18:36
 */
public class Solution171 {
    public static void main(String[] args) {
//        System.out.println((char)64);
        System.out.println(new Solution171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        // 26进制
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int num = c - '@';
            res = res * 26 + num;
        }
        return res;
    }
}
