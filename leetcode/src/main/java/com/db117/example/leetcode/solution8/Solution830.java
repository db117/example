package com.db117.example.leetcode.solution8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 * <p>
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 * <p>
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/9/009 18:05
 */
public class Solution830 {
    public static void main(String[] args) {
        System.out.println(new Solution830().largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public List<List<Integer>> largeGroupPositions(String s) {

        if (s == null || s.length() < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        char[] chars = s.toCharArray();

        int headIndex = 0;
        char head = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != head) {
                if (i - headIndex >= 3) {
                    // 连续大于等于3时
                    List<Integer> list = new ArrayList<>();
                    list.add(headIndex);
                    list.add(i - 1);
                    res.add(list);
                }
                // 重置数据
                headIndex = i;
                head = chars[i];
            }
        }

        // 最后一个字符等于上一个字符
        if (head == chars[chars.length - 1] && chars.length - headIndex >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(headIndex);
            list.add(chars.length - 1);
            res.add(list);
        }

        return res;
    }
}
