package com.db117.example.leetcode.solution2;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author db117
 * @date 2019/7/23/023
 **/

public class Solution204 {
    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(1));
    }

    public int countPrimes(int n) {

        boolean[] flag = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i < n; i++) {
            // 从2开始,把i的倍数设置为true
            for (int j = i + i; j <= n; j += i) {
                flag[j] = true;
            }
        }

        // 从2开始统计false的数量
        for (int i = 2; i < flag.length - 1; i++) {
            count += flag[i] ? 0 : 1;
        }
        return count;
    }
}
