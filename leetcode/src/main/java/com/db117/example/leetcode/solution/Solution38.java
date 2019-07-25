package com.db117.example.leetcode.solution;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/19
 **/

public class Solution38 {

    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        for (int i = 0; i < n - 1; i++) {
            res = dfs(res);
        }
        return res;
    }

    public String dfs(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < len) {
            int count = 1;
            // 一直找到下一个不一样的
            while (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(count).append(s.charAt(i));
            i++;
        }
        return res.toString();
    }
}
