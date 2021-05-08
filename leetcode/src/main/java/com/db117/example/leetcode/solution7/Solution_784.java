// 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 270 👎 0


package com.db117.example.leetcode.solution7;

import java.util.LinkedList;
import java.util.List;

/**
 * 784.字母大小写全排列.letter-case-permutation
 *
 * @author db117
 * @since 2021-05-07 16:43:07
 **/

public class Solution_784 {
    public static void main(String[] args) {
        Solution solution = new Solution_784().new Solution();

        System.out.println(solution.letterCasePermutation("a1b2"));
        System.out.println(solution.letterCasePermutation("3z4"));
        System.out.println(solution.letterCasePermutation("12345"));

        // ["mqe","mqE","mQe","mQE","Mqe","MqE","MQe","MQE"]
        List<String> list = solution.letterCasePermutation("mQe");
        System.out.println(list);
//        list.removeAll(Arrays.asList("mqe", "mqE", "mQe", "mQE", "Mqe", "MqE", "MQe", "MQE"));
//        System.out.println(new HashSet<>(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> ans = new LinkedList<>();


        public List<String> letterCasePermutation(String S) {
            char[] chars = S.toCharArray();
            dfs(chars, 0);
            return ans;
        }


        private void dfs(char[] chars, int index) {

            if (index >= chars.length) {
                ans.add(new String(chars));
                return;
            }

            // 不对当前字符处理
            dfs(chars, index + 1);
            if (chars[index] > '9') {
                // 如果是字母则转换大小写
                chars[index] ^= 1 << 5;
                dfs(chars, index + 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}