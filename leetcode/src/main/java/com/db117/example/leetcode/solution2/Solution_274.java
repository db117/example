//给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
//
// h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引
//用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。 
//
// 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。 
//
// 
//
// 示例： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 
//
// 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。 
// Related Topics 排序 哈希表 
// 👍 125 👎 0


package com.db117.example.leetcode.solution2;

import java.util.Arrays;

/**
 * 274.H 指数.h-index
 *
 * @author db117
 * @since 2021-02-04 11:18:29
 **/

public class Solution_274 {
    public static void main(String[] args) {
        Solution solution = new Solution_274().new Solution();
        System.out.println(solution.hIndex(new int[]{
                1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {

            Arrays.sort(citations);
            for (int i = citations.length - 1; i >= 0; i--) {
                // 最少被引用的次数
                int num = citations[i];
                // 最后有多少篇论文的引用次数大于等于当前引用次数
                int count = citations.length - i;

                // 找到第一个引用数小于后面的论文数
                if (num < count) {
                    return count - 1;
                }
            }
            // 找不到不符合的,则全部都符合
            return citations.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}