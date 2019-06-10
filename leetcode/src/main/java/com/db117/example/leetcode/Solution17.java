package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author db117
 * @date 2019/6/6
 **/
@Slf4j
public class Solution17 {
    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("29"));
    }

    /**
     * 映射
     */
    private static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    /**
     * 返回值
     */
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 为空情况
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // 递归
        dg(digits.toCharArray(), new char[0]);
        return res;
    }

    public void dg(char[] data, char[] s) {
        // 结束条件
        if (data.length == 0) {
            res.add(new String(s));
            return;
        }
        char c = data[0];
        String s1 = map.get(c);

        char[] one = new char[data.length - 1];
        char[] two = new char[s.length + 1];
        System.arraycopy(data, 1, one, 0, one.length);
        System.arraycopy(s, 0, two, 0, s.length);
        for (int i = 0; i < s1.length(); i++) {
            two[s.length] = s1.charAt(i);
            dg(one, two);
        }
    }
}
