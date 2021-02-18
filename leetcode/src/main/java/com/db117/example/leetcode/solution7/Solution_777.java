//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回T
//rue。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
// Related Topics 脑筋急转弯 
// 👍 84 👎 0


package com.db117.example.leetcode.solution7;

/**
 * 777.在LR字符串中交换相邻字符.swap-adjacent-in-lr-string
 *
 * @author db117
 * @since 2021-02-10 10:39:19
 **/

public class Solution_777 {
    public static void main(String[] args) {
        Solution solution = new Solution_777().new Solution();
        System.out.println(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String end) {
            if (start.equals(end)) {
                return true;
            }
            // R L 的顺序需要一样
            if (!start.replace("X", "").equals(end.replace("X", ""))) {
                return false;
            }

            // "LX"替换一个"XL"  "XR"替换一个"RX"
            // 即L往右边移动  R往左边移动
            int j = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'L') {
                    while (j < end.length() && end.charAt(j) != 'L') {
                        // end中下一个L的位置
                        j++;
                    }
                    if (j > i) {
                        // L只能往右边移动
                        return false;
                    }
                    j++;
                }
            }
            j = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'R') {
                    while (j < end.length() && end.charAt(j) != 'R') {
                        // end中下一个R的位置
                        j++;
                    }
                    if (j < i) {
                        // R只能往左边移动
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}