package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/6/13
 **/
@Slf4j
public class Solution30 {
    public static void main(String[] args) {
        System.out.println(new Solution30().findSubstring("mississippi", new String[]{"is"}));
//        System.out.println(new Solution30().findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
//                , new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 过滤
        if (s == null || s.length() == 0 || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return res;
        }
        // 单词->出现次数
        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int length = s.length();
        // 单个单词长度
        int len = words[0].length();
        // 匹配字符串长度
        int total = len * words.length;
        // 匹配次数
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            map.clear();
            // 双指针
            while (right <= length - len && left <= length - total) {
                String word = s.substring(right, right += len);
                if (!wordMap.containsKey(word)) {
                    // 没有找到直接匹配次数
                    map.clear();
                    // 左指针右移
                    left += len;
                    right = left;
                    continue;
                }

                map.put(word, map.getOrDefault(word, 0) + 1);

                if (map.getOrDefault(word, 0) > wordMap.getOrDefault(word, 0)) {
                    // 有多余的结束
                    map.clear();
                    // 左指针右移
                    left += len;
                    right = left;
                    continue;
                }

                if (right - left == total) {
                    // 找到
                    res.add(left);
                    map.clear();
                    left += len;
                    right = left;
                }
            }
        }
        return res;
    }

    /**
     * 不重复全排列
     *
     * @param res   容器
     * @param words 源
     * @param index 目标索引
     * @param flags 选择标记
     * @param to    目标
     */
    void gen(List<String> res, String[] words, int index, boolean[] flags, String[] to) {
        // 索引等于源时结束
        if (index == flags.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : to) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < flags.length; i++) {
            // 当当前位置没有使用过时,标记为使用过,进行递归运算后设为未使用
            if (!flags[i]) {
                flags[i] = true;
                to[index] = words[i];
                gen(res, words, index + 1, flags, to);
                flags[i] = false;
            }
        }
    }

}
