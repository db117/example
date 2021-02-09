//给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
//
// h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别
//被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）" 
//
// 
//
// 示例: 
//
// 输入: citations = [0,1,3,5,6]
//输出: 3 
//解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
//     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。 
//
// 
//
// 说明: 
//
// 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。 
//
// 
//
// 进阶： 
//
// 
// 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。 
// 你可以优化你的算法到对数时间复杂度吗？ 
// 
// Related Topics 二分查找 
// 👍 87 👎 0


package com.db117.example.leetcode.solution2;

/**
 * 275.H 指数 II.h-index-ii
 *
 * @author db117
 * @since 2021-02-09 11:37:30
 **/

public class Solution_275 {
    public static void main(String[] args) {
        Solution solution = new Solution_275().new Solution();
        System.out.println(solution.hIndex(new int[]{
                0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            if (citations.length == 1) {
                // 只有一个元素,直接判断
                return citations[0] > 0 ? 1 : 0;
            }

            int left = 0, right = citations.length - 1;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;

                // 论文引用次数
                int count = citations[mid];
                // 引用次数比当前次数大的论文数量
                int num = citations.length - mid;
                if (count >= num) {
                    right = mid - 1;
                } else {
                    if (mid < citations.length - 1 && citations[mid + 1] >= num - 1) {
                        // 找到了第一个不符合要求的数字
                        return num - 1;
                    }
                    left = mid + 1;
                }
            }

            if (right <= 0) {
                // 全部符合
                return citations.length;
            }
            if (left >= citations.length - 1) {
                // 没有找到符合条件的
                return 0;
            }

            return 0;
        }

        int bs(int[] ints) {

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}