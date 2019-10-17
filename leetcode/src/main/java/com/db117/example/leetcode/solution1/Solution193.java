package com.db117.example.leetcode.solution1;

import java.util.regex.Pattern;

/**
 * 193. 有效电话号码
 * 给定一个包含电话号码列表（一行一个电话号码）的文本文件 file.txt，写一个 bash 脚本输出所有有效的电话号码。
 * <p>
 * 你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）
 * <p>
 * 你也可以假设每行前后没有多余的空格字符。
 * <p>
 * 示例:
 * <p>
 * 假设 file.txt 内容如下：
 * <p>
 * 987-123-4567
 * 123 456 7890
 * (123) 456-7890
 * 你的脚本应当输出下列有效的电话号码：
 * <p>
 * 987-123-4567
 * (123) 456-7890
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-phone-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/17/017 14:05
 */
public class Solution193 {

    // grep -P "^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$" file.txt
    public static void main(String[] args) {
        String p = "(\\d{3}-|\\(\\d{3}\\) )\\d{3}-\\d{4}";
        Pattern compile = Pattern.compile(p);

        System.out.println(compile.matcher("(001) 345-0000").find());
    }
}
