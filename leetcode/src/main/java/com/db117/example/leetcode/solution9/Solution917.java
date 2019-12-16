package com.db117.example.leetcode.solution9;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/16/016 11:43
 */
public class Solution917 {
    public static void main(String[] args) {
        System.out.println(new Solution917().reverseOnlyLetters("7_28]"));
    }

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        // 双指针
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
