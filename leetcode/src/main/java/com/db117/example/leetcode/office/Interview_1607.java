//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学 
// 👍 72 👎 0


package com.db117.example.leetcode.office;

/**
 * 面试题 16.07.最大数值.maximum-lcci
 *
 * @author db117
 * @since 2021-01-18 18:52:41
 **/

public class Interview_1607 {
    public static void main(String[] args) {
        Solution solution = new Interview_1607().new Solution();
        System.out.println(solution.maximum(-9, -7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            // 符号位
            // 1 则b大
            // 0 则a大于等于b
            int n = (int) (((long) a - (long) b) >>> 63);
            return a * (1 - n) | b * n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}