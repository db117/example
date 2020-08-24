//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
// 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
// 和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
//，不能则返回False。 
//
// 示例 1: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
// 
//
// 注意: 
//
// 
// 数组内已种好的花不会违反种植规则。 
// 输入的数组长度范围为 [1, 20000]。 
// n 是非负整数，且不会超过输入数组的大小。 
// 
// Related Topics 数组 
// 👍 165 👎 0


package com.db117.example.leetcode.solution6;

/**
 * 605.种花问题
 *
 * @author db117
 * @date 2020-08-24 15:54:26
 **/
public class Solution605 {
    public static void main(String[] args) {
        Solution solution = new Solution605().new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{
                1, 0, 0, 0, 0
        }, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // 开始的位置需要加1
            // 连续的空位置
            int count = 1;
            for (int j : flowerbed) {
                if (j == 1) {
                    // 连续空位置能放几个花
                    n -= (count - 1) / 2;
                    if (n <= 0) {
                        return true;
                    }
                    count = 0;
                } else {
                    count++;
                }
            }
            // 处理最后一段
            // 跟第一段一样,最后面可以放花
            count++;
            n -= (count - 1) / 2;

            return n <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}