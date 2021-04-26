// 我们有一个非负整数数组 A。
//
// 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果
// A[i] | A[i+1] | ... | A[j]。 
//
// 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。） 
//
// 
//
// 示例 1： 
//
// 输入：[0]
//输出：1
//解释：
//只有一个可能的结果 0 。
// 
//
// 示例 2： 
//
// 输入：[1,1,2]
//输出：3
//解释：
//可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
//产生的结果为 1，1，2，1，3，3 。
//有三个唯一值，所以答案是 3 。
// 
//
// 示例 3： 
//
// 输入：[1,2,4]
//输出：6
//解释：
//可能的结果是 1，2，3，4，6，以及 7 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 位运算 动态规划 
// 👍 85 👎 0


package com.db117.example.leetcode.solution8;

import java.util.HashSet;
import java.util.Set;

/**
 * 898.子数组按位或操作.bitwise-ors-of-subarrays
 *
 * @author db117
 * @since 2021-04-25 17:13:27
 **/

public class Solution_898 {
    public static void main(String[] args) {
        Solution solution = new Solution_898().new Solution();
        // 26
        // 1,3,4,6,78,5,8,5,3,2,1,1,1,4,566,7,3,232,656,77
        System.out.println(solution.subarrayBitwiseORs(new int[]{1,3,4,6,78,5,8,5,3,2,1,1,1,4,566,7,3,232,656,77}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> set = new HashSet<>();
            // 循环往前找
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if ((arr[i] | arr[j]) == arr[j]) {
                        // 后面没有必要继续进行了
                        break;
                    }
                    // 直接修改不影响
                    // [j-1,i] >= [j,i]
                    arr[j] |= arr[j + 1];
                    set.add(arr[j]);
                }
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}