package com.db117.example.leetcode.solution8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 884. 两句话中的不常见单词
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/25/025 17:20
 */
public class Solution884 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution884().uncommonFromSentences("this apple is sweet"
                , "this apple is sour")));
    }

    public String[] uncommonFromSentences(String A, String B) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // 如果已经有了则加入到另一个中
        for (String s : A.split(" ")) {
            if (!set1.add(s)) {
                set2.add(s);
            }
        }

        for (String s : B.split(" ")) {
            if (!set2.add(s)) {
                set1.add(s);
            }
        }

        // 删除都有的
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (set2.contains(next)) {
                iterator.remove();
                set2.remove(next);
            }
        }


        set1.addAll(set2);
        return set1.toArray(new String[0]);
    }
}
