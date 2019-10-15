package com.db117.example.leetcode.solution8;

import java.util.Arrays;

/**
 * 899. 有序队列
 * 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
 * <p>
 * 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
 * <p>
 * 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "cba", K = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 * <p>
 * 输入：S = "baaca", K = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= S.length <= 1000
 * S 只由小写字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/orderly-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/10/11/011 14:30
 */
public class Solution899 {
    public static void main(String[] args) {
        System.out.println(new Solution899().orderlyQueue("aacab", 2));
    }

    public String orderlyQueue(String s, int k) {

        // 如果k为一,循序不可变,即找到从哪个字符串开始的最小的
        if (k == 1) {
            String min = s;
            for (int i = 0; i < s.length(); i++) {
                String s1 = s.substring(i) + s.substring(0, i);
                if (min.compareTo(s1) > 0) {
                    min = s1;
                }

            }
            return min;
        } else {
            // 如果k大于2,则可以随意排列,即直接按字符排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}
