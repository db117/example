package com.db117.example.leetcode.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/20/020
 */
public class Solution131 {
    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aaB"));
    }

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>(s.length()));
        return res;
    }

    public void dfs(String s, int index, List<String> cur) {
        if (s.length() == index) {
            // 找到添加
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // 是回文
            if (isp(s, index, i)) {
                cur.add(s.substring(index, i + 1));

                // 从下一个字符开始
                dfs(s, i + 1, cur);

                cur.remove(cur.size() - 1);
            }
        }

    }

    // 是否是回文
    public boolean isp(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
