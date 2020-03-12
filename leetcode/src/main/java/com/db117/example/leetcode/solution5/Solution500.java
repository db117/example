package com.db117.example.leetcode.solution5;

import java.util.ArrayList;
import java.util.List;

/**
 * 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 * <p>
 * 注意：
 * <p>
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @since 2020/3/12 16:25
 */
public class Solution500 {
    public static void main(String[] args) {
        System.out.println((int) 'A');
    }

    public String[] findWords(String[] words) {
        // 字母在的行数
        int[] temp = new int[]{1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (helper(word, temp)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean helper(String word, int[] temp) {
        char[] chars = word.toUpperCase().toCharArray();
        int i = temp[chars[0] - 'A'];
        for (char c : chars) {
            if (i != temp[(c - 'A')]) {
                return false;
            }
        }
        return true;
    }
}
