//珠玑妙算游戏（the game of master mind）的玩法如下。
// 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽
//4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
//注意，“猜中”不能算入“伪猜中”。 
// 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[
//1]为伪猜中的次数。 
// 示例： 
// 输入： solution="RGBY",guess="GGRR"
//输出： [1,1]
//解释： 猜中1次，伪猜中1次。
// 
// 提示： 
// 
// len(solution) = len(guess) = 4 
// solution和guess仅包含"R","G","B","Y"这4种字符 
// 
// Related Topics 数组 
// 👍 18 👎 0


package com.db117.example.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 16.15.珠玑妙算.master-mind-lcci
 *
 * @author db117
 * @since 2021-01-19 14:10:32
 **/

public class Interview_1615 {
    public static void main(String[] args) {

        Solution solution = new Interview_1615().new Solution();
        System.out.println(Arrays.toString(solution.masterMind("RGBY", "GGRR")));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] masterMind(String solution, String guess) {
            int[] ans = new int[]{0, 0};
            StringBuilder s1 = new StringBuilder(solution);
            StringBuilder s2 = new StringBuilder(guess);

            // 猜中了
            for (int i = 3; i >= 0; i--) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(i);
                    ans[0]++;
                }
            }


            // 伪猜中
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);

                for (int j = 0; j < s2.length(); j++) {
                    if (s2.charAt(j) == c) {
                        // 猜中了删除掉
                        s2.deleteCharAt(j);
                        ans[1]++;
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}