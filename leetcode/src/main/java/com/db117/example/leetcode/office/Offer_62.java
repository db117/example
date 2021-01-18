//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 282 👎 0


package com.db117.example.leetcode.office;

import com.db117.example.leetcode.base.Optimized;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62.圆圈中最后剩下的数字.yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-18 17:00:23
 **/
@Optimized
public class Offer_62 {
    public static void main(String[] args) {
        Solution solution = new Offer_62().new Solution();
        System.out.println(solution.lastRemaining(10, 17));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            // 可以用,约瑟夫环

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }

            // 模拟
            int cur = 0;
            while (list.size() > 1) {
                cur = (cur + m - 1) % list.size();
                list.remove(cur);
            }
            return list.get(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}