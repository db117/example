package com.db117.example.leetcode.solution5;

import lombok.extern.slf4j.Slf4j;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/16
 **/
@Slf4j
public class Solution557 {
    public static void main(String[] args) {
        System.out.println(new Solution557().reverseWords1("Let's take LeetCode contest"));
    }

    public String reverseWords1(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int index = 0;
        while (index < len) {
            // 单词长度
            int temp = 0;
            // 找到空格
            while (index < len) {
                if (chars[index] == ' ') {
                    break;
                }
                temp++;
                index++;
            }
            // 交换
            reverse(chars, index - temp, index - 1);
            index++;
        }
        return new String(chars);
    }

    /**
     * 交换
     */
    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            // 使用StringBuilder进行翻转
            sb.append(new StringBuilder(s1).reverse()).append(" ");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            return "";
        }
        return sb.toString();
    }
}
