package com.db117.example.leetcode.solution;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/5
 **/

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        // 转换为数组
        int[] ints = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i)]++;
        }

        // 左右指针
        int left = 0, right = 0;
        // 返回左右指针
        int resLeft = 0, resRight = -1;
        // 最小长度
        int resLen = Integer.MAX_VALUE;
        // 需要匹配得个数
        int count = t.length();

        while (right < s.length()) {
            // 先移动右指针
            char cRight = s.charAt(right);
            // 当前数字减一
            ints[cRight]--;

            // 如果当前数字大于等于0,说明当前位置有字符
            if (ints[cRight] >= 0) {
                count--;
            }

            // 确定左指针
            while (count == 0) {
                // 当前窗口大小
                int curLen = right - left + 1;

                // 当前窗口小于保存的
                if (curLen < resLen) {
                    resLen = curLen;
                    resLeft = left;
                    resRight = right;
                }

                char cLeft = s.charAt(left);
                // 左边减少,对应的数组的数字加一
                ints[cLeft]++;
                // 如果对应的数字大一0,则说明需要匹配的字符被删除(没有在匹配的字符串中的数字永远不会大于0)
                if (ints[cLeft] > 0) {
                    count++;
                }
                left++;
            }
            right++;
        }
        return s.substring(resLeft, resRight + 1);
    }
}
