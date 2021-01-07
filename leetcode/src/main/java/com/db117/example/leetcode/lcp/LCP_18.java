


//小扣在秋日市集选择了一家早餐摊位，一维整型数组 `staple` 中记录了每种主食的价格，一维整型数组 `drinks` 中记录了每种饮料的价格。小扣的计划
//选择一份主食和一款饮料，且花费不超过 `x` 元。请返回小扣共有多少种购买方案。
//
//注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
//
//**示例 1：**
//>输入：`staple = [10,20,5], drinks = [5,5,2], x = 15`
//>
//>输出：`6`
//>
//>解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
//>第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
//>第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
//>第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
//>第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
//>第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
//>第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
//
//**示例 2：**
//>输入：`staple = [2,1,1], drinks = [8,9,5,1], x = 9`
//>
//>输出：`8`
//>
//>解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
//>第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
//>第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
//>第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
//>第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
//>第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
//>第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
//>第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
//>第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
//
//**提示：**
//+ `1 <= staple.length <= 10^5`
//+ `1 <= drinks.length <= 10^5`
//+ `1 <= staple[i],drinks[i] <= 10^5`
//+ `1 <= x <= 2*10^5` 👍 35 👎 0


package com.db117.example.leetcode.lcp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LCP 18.早餐组合.2vYnGI
 *
 * @author db117
 * @since 2021-01-05 15:45:25
 **/

public class LCP_18 {
    public static void main(String[] args) {
        Solution solution = new LCP_18().new Solution();
        // [10,20,5]
        //[5,5,2]
        //15
        System.out.println(solution.breakfastNumber(new int[]{
                10, 20, 5
        }, new int[]{
                5, 5, 2
        }, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int l = 1000000007;

        public int breakfastNumber(int[] staple, int[] drinks, int x) {

            Arrays.sort(drinks);
            // 不同主食的价格可以选择的数量
            // 缓存
            Map<Integer, Integer> map = new HashMap<>();

            int res = 0;
            for (int i : staple) {
                if (i >= x) {
                    continue;
                }

                if (map.containsKey(i)) {
                    res += map.get(i);
                    continue;
                }

                int bs = bs(drinks, x - i);
                if (bs != -1) {
                    map.put(i, bs + 1);
                    res += bs + 1;
                }
                if (res > l) {
                    res %= l;
                }
            }
            return res;
        }

        // 小于等于目标值的最右边
        public int bs(int[] drinks, int target) {
            int left = 0, right = drinks.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                int num = drinks[mid];
                if (num < target) {
                    left = mid + 1;
                } else if (num > target) {
                    right = mid - 1;
                } else {
                    if (mid == drinks.length - 1 || drinks[mid + 1] != target) {
                        // 找到了
                        return mid;
                    }
                    left = mid + 1;
                }
            }
            if (right < 0) {
                return -1;
            }

            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}