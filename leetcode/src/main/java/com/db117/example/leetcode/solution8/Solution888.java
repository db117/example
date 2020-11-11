//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。 
//
// 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 80 👎 0


package com.db117.example.leetcode.solution8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888.公平的糖果交换.fair-candy-swap
 *
 * @author db117
 * @since 2020-11-11 10:13:42
 **/

public class Solution888 {
    public static void main(String[] args) {
        Solution solution = new Solution888().new Solution();
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{
                1, 1
        }, new int[]{
                2, 2
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int[] res = new int[2];
            Set<Integer> aSet = new HashSet<>();
            Set<Integer> bSet = new HashSet<>();
            int aSum = 0, bSum = 0;
            for (int i : A) {
                aSum += i;
                aSet.add(i);
            }
            for (int i : B) {
                bSum += i;
                bSet.add(i);
            }
            // 找到差值
            int n = (aSum - bSum) / 2;


            for (Integer i : aSet) {
                // a比b的和大
                if (bSet.contains(i - n)) {
                    res[0] = i;
                    res[1] = i - n;
                    return res;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}