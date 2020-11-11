//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 168 👎 0


package com.db117.example.leetcode.solution9;

/**
 * 925.长按键入.long-pressed-name
 *
 * @author db117
 * @since 2020-11-11 15:50:31
 **/

public class Solution925 {
    public static void main(String[] args) {
        Solution solution = new Solution925().new Solution();

        System.out.println(solution.isLongPressedName("saeed", "ssaaedd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            if (name.equals(typed)) {
                return true;
            }
            char[] names = name.toCharArray();
            char[] types = typed.toCharArray();


            int tI = 0, nI = 0;
            while (nI < names.length) {
                if (tI >= types.length) {
                    // typed没有字符了
                    return false;
                }

                if (names[nI] != types[tI]) {
                    if (nI > 0 && types[tI] == names[nI - 1]) {
                        // 如果typed的当前字符等于name的之前的字符,说明typed当前的支付是长按的
                        tI++;
                        continue;
                    }
                    return false;
                }
                if (nI == names.length - 1) {
                    // 最后一个字符,如果有其他字符则不符合
                    while (tI < types.length) {
                        if (types[tI++] != names[nI]) {
                            return false;
                        }
                    }
                }
                nI++;
                tI++;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}