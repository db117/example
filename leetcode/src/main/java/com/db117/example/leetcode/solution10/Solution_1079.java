// 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 输入："AAABBC"
//输出：188
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
// Related Topics 回溯算法 
// 👍 111 👎 0


package com.db117.example.leetcode.solution10;

/**
 * 1079.活字印刷.letter-tile-possibilities
 *
 * @author db117
 * @since 2021-05-12 18:21:28
 **/

public class Solution_1079 {
    public static void main(String[] args) {
        Solution solution = new Solution_1079().new Solution();

//        System.out.println(solution.numTilePossibilities("AAB"));
        System.out.println(solution.numTilePossibilities("AAABBC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans;

        public int numTilePossibilities(String tiles) {
            char[] chars = tiles.toCharArray();
            // 统计每一个字符出现的次数
            byte[] count = new byte[26];
            for (char c : chars) {
                count[c - 'A']++;
            }

            dfs(count);

            return ans;
        }

        private void dfs(byte[] count) {
            for (int i = 0; i < 26; i++) {
                // 用完了就没有了
                if (count[i] == 0) {
                    continue;
                }

                // 每一个字符用一次都是一个新的字符串
                ans++;

                count[i]--;

                // 剩下的所有可能
                dfs(count);

                // 回溯
                count[i]++;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}