//你有一个日志数组 logs。每条日志都是以空格分隔的字串。 
//
// 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。 
//
// 
// 除标识符之外，所有字均由小写字母组成的，称为 字母日志 
// 除标识符之外，所有字均由数字组成的，称为 数字日志 
// 
//
// 题目所用数据保证每个日志在其标识符后面至少有一个字。 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序； 
// 数字日志 应该按原来的顺序排列。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 ： 
//
// 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 保证有一个标识符，并且标识符后面有一个字。 
// 
// Related Topics 字符串 
// 👍 49 👎 0


package com.db117.example.leetcode.solution9;

import java.util.Arrays;

/**
 * 937.重新排列日志文件.reorder-data-in-log-files
 *
 * @author db117
 * @since 2020-11-12 18:42:10
 **/

public class Solution937 {
    public static void main(String[] args) {
        Solution solution = new Solution937().new Solution();

        System.out.println(Arrays.toString(solution.reorderLogFiles(new String[]{
                "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"
        })));
    }

    //leetcode submit region begin(Prohibit modificationand deletion)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (o1, o2) -> {
                char c1 = o1.charAt(o1.length() - 1);
                char c2 = o2.charAt(o2.length() - 1);
                // 是否为字符
                boolean flag1 = c1 >= 'a';
                boolean flag2 = c2 >= 'a';

                if (!flag1 && !flag2) {
                    // 都为数字,不改变顺序
                    return 0;
                }
                if (flag1 && flag2) {
                    // 都为字符串
                    String sub1 = o1.substring(o1.indexOf(' ') + 1);
                    String sub2 = o2.substring(o2.indexOf(' ') + 1);
                    int compare = sub1.compareTo(sub2);

                    if (compare == 0) {
                        // 日志相同则按照标识符排序
                        return o1.compareTo(o2);
                    }

                    return compare;
                }
                // 字符在前
                return flag1 ? -1 : 1;
            });

            return logs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}