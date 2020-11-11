//你将得到一个字符串数组 A。 
//
// 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。 
//
// 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。 
//
// 例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得
// "zzxy" -> "xzzy" -> "xyzz" 。 
//
// 现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集： 
//
// 
// 该组中的每一对字符串都是 特殊等价 的 
// 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特
//殊等价） 
// 
//
// 返回 A 中特殊等价字符串组的数量。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
//输出：3
//解释：
//其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
//另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
// 
//
// 示例 2： 
//
// 输入：["abc","acb","bac","bca","cab","cba"]
//输出：3
//解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 1000 
// 1 <= A[i].length <= 20 
// 所有 A[i] 都具有相同的长度。 
// 所有 A[i] 都只由小写字母组成。 
// 
// Related Topics 字符串 
// 👍 88 👎 0


package com.db117.example.leetcode.solution8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893.特殊等价字符串组.groups-of-special-equivalent-strings
 *
 * @author db117
 * @since 2020-11-11 14:41:35
 **/

public class Solution893 {
    public static void main(String[] args) {
        Solution solution = new Solution893().new Solution();
        System.out.println(solution.numSpecialEquivGroups(new String[]{
                "demp", "cfhp", "dzvf", "ggxe", "hkte", "clug", "nhgk", "hvwj", "zozr",
                "datm", "hisr", "gfry", "jknr", "laju", "emsf", "duwe", "ilta", "gjrd",
                "woaq", "zhdm", "ujmz", "jalu", "tkhe", "gexg", "hrsi", "tail", "ilta",
                "xegg", "srhi", "clug", "cgul", "gexg", "tehk", "ulcg", "xgge", "cgul",
                "hrsi", "aowq", "jalu", "laju", "vzdf", "gexg", "hpcf", "zhdm", "hfcp",
                "zhdm", "ulcg", "jalu", "ggxe", "gexg", "nkgh", "hrsi", "vfdz", "nkgh",
                "cgul", "hpcf", "hetk", "zrzo", "xegg", "nkgh", "srhi", "smef", "ulcg",
                "hrsi", "ggxe", "ggxe", "efsm", "ggxe", "jalu", "srhi", "dmzh", "laju",
                "zmdh", "sfem", "tehk", "srhi", "wqao", "gknh", "jalu", "iatl", "gexg",
                "ugcl", "nkgh", "hrsi", "srhi", "hkte", "gdrj", "zozr", "hisr", "sihr",
                "smef", "zmdh", "clug", "iatl", "cgul", "woaq", "jrnk", "sihr", "xegg", "luja"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numSpecialEquivGroups(String[] A) {
            // 26个质数,可以分辨出字符串组合
            int[] tmp = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
            // 组
            Set<String> set = new HashSet<>();

            for (String s : A) {

                int oddSum = 1, evenSum = 1;

                for (int i = 0; i < s.length(); i++) {
                    int num = tmp[s.charAt(i) - 'a'];
                    // 质数相乘,不同组的值唯一
                    if ((i & 1) == 0) {
                        evenSum *= num;
                    } else {
                        oddSum *= num;
                    }
                }

                set.add(oddSum + "." + evenSum);
            }

            return set.size();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        int[] oddTmp = new int[26];
        int[] evenTmp = new int[26];

        public int numSpecialEquivGroups(String[] A) {
            // 组的数量
            int group = 0;
            // 标记是否已经分组
            boolean[] flag = new boolean[A.length];

            for (int i = 0; i < A.length; i++) {
                if (!flag[i]) {
                    // 找到没有分组的字符串,往后把所有的同类都找到
                    for (int j = 0; j < A.length; j++) {
                        if (!flag[j] && check(A[i], A[j])) {
                            // 找到后标记以分组
                            flag[j] = true;
                        }
                    }
                    group++;
                }
            }
            return group;
        }

        private boolean check(String s, String t) {
            Arrays.fill(oddTmp, 0);
            Arrays.fill(evenTmp, 0);

            // 记录奇数偶数位置的字符数
            for (int i = 0; i < s.length(); i++) {
                if ((i & 1) == 0) {
                    evenTmp[s.charAt(i) - 'a']++;
                    evenTmp[t.charAt(i) - 'a']--;
                } else {
                    oddTmp[s.charAt(i) - 'a']++;
                    oddTmp[t.charAt(i) - 'a']--;
                }
            }

            // 当所有位置都为0时,则为一组
            for (int i = 0; i < oddTmp.length; i++) {
                if (oddTmp[i] != 0 || evenTmp[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}