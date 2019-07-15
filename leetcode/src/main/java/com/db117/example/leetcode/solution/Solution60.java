package com.db117.example.leetcode.solution;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/1
 **/
@Slf4j
public class Solution60 {
    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 9));
    }

    // 模仿
    public String getPermutation(int n, int k) {
        // 阶乘缓存
        int[] cache = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        StringBuilder res = new StringBuilder();
        // 需要取de数字
        List<Integer> temp = new ArrayList<>();
        // 充填数字
        for (int i = 0; i < n; i++) {
            temp.add(i + 1);
        }
        // 刚好相等应该取当前数字,所以减一
        k -= 1;
        for (int i = n - 1; i >= 0; i--) {
            // 剩余数字穷举应该有多少,求出当前为的位置
            int index = k / cache[i];
            res.append(temp.remove(index));
            k = k - index * cache[i];
        }
        return res.toString();
    }
}
