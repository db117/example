//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。 
//
// 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。 
//
// 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：path = "NES"
//输出：false 
//解释：该路径没有在任何位置相交。 
//
// 示例 2： 
//
// 
//
// 输入：path = "NESWW"
//输出：true
//解释：该路径经过原点两次。 
//
// 
//
// 提示： 
//
// 
// 1 <= path.length <= 10^4 
// path 仅由 {'N', 'S', 'E', 'W} 中的字符组成 
// 
// Related Topics 字符串 
// 👍 19 👎 0


package com.db117.example.leetcode.solution14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1496.判断路径是否相交.path-crossing
 *
 * @author db117
 * @since 2020-12-22 17:13:26
 **/

public class Solution1496 {
    public static void main(String[] args) {
        Solution solution = new Solution1496().new Solution();
        System.out.println(solution.isPathCrossing("NES"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Map<Character, int[]> map = new HashMap<>();

        {
            map.put('N', new int[]{1, 0});
            map.put('S', new int[]{-1, 0});
            map.put('E', new int[]{0, 1});
            map.put('W', new int[]{0, -1});
        }

        public boolean isPathCrossing(String path) {
            Set<String> set = new HashSet<>();

            // 原点
            int x = 0, y = 0;
            set.add("0-0");
            for (char c : path.toCharArray()) {
                // 走起来
                int[] ints = map.get(c);
                x += ints[0];
                y += ints[1];

                String temp = x + "-" + y;
                // 已经走过了
                if (set.contains(temp)) {
                    return true;
                }

                set.add(temp);
            }

            // 没有出现相交的情况
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}