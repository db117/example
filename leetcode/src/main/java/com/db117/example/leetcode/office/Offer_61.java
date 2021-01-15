//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 88 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 61.扑克牌中的顺子.bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * @author db117
 * @since 2021-01-15 15:55:36
 **/

public class Offer_61 {
    public static void main(String[] args) {
        Solution solution = new Offer_61().new Solution();
        System.out.println(solution.isStraight(new int[]{
                0, 0, 1, 2, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            int[] tmp = new int[14];
            int max = -1, min = 15;

            // 查找最大值,最小值
            // 记录每个数字出现的次数
            for (int num : nums) {
                tmp[num]++;
                if (num != 0) {
                    max = Math.max(max, num);
                    min = Math.min(min, num);
                }
            }

            // 最大最小值差距过大这不可能是连续的
            if (max - 4 > min) {
                return false;
            }

            // 如果有个数字出现两次
            for (int i = 1; i < tmp.length; i++) {
                if (tmp[i] > 1) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}