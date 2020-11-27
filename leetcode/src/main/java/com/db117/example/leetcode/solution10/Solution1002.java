//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
// 例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 188 👎 0


package com.db117.example.leetcode.solution10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1002.查找常用字符.find-common-characters
 *
 * @author db117
 * @since 2020-11-26 15:18:22
 **/

public class Solution1002 {
    public static void main(String[] args) {
        Solution solution = new Solution1002().new Solution();

        System.out.println(solution.commonChars(new String[]{
                "cool", "lock", "cook"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            // 记录字符在各个字符串上出现次数的最小值
            int[] min = new int[26];
            Arrays.fill(min, Integer.MAX_VALUE);

            int[] temp = new int[26];
            for (String s : A) {
                for (int i = 0; i < s.length(); i++) {
                    temp[s.charAt(i) - 'a']++;
                }

                // 获取最小值
                for (int i = 0; i < min.length; i++) {
                    min[i] = Math.min(min[i], temp[i]);
                }

                // 重置数据
                Arrays.fill(temp, 0);
            }

            List<String> res = new LinkedList<>();

            for (int i = 0; i < min.length; i++) {
                if (min[i] != 0) {

                    for (int i1 = 0; i1 < min[i]; i1++) {
                        res.add(String.valueOf((char) (i + 'a')));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}