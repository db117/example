package com.db117.example.leetcode.solution4;

import java.util.Arrays;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/31/031 15:16
 */
public class Solution434 {
    public static void main(String[] args) {
        System.out.println(new Solution434().countSegments(""));
    }

    public int countSegments(String s) {
        return (int) Arrays.stream(s.split(" "))
                .filter(s1 -> !"".equals(s1)).count();
    }
}
