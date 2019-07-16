package com.db117.example.leetcode.solution3;

import lombok.extern.slf4j.Slf4j;

/**
 * 345. 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/16
 **/
@Slf4j
public class Solution345 {
    // 元音包括a，e，i，o，u，A，E，I，O，U

    public static void main(String[] args) {
        System.out.println(new Solution345().reverseVowels("leetcode"));
    }

    public static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // 找到左边的元音
            while (left < right) {
                if (check(chars[left])) {
                    break;
                }
                left++;
            }
            // 找到右边的元音

            while (left < right) {
                if (check(chars[right])) {
                    break;
                }
                right--;
            }

            // 交换
            if (left != right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }


}
