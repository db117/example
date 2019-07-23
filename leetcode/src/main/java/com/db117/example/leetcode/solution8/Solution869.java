package com.db117.example.leetcode.solution8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/23/023
 **/
@Slf4j
public class Solution869 {
    public static void main(String[] args) {
        System.out.println(new Solution869().reorderedPowerOf2(563870912));
    }

    /**
     * 10的9次方内的2的幂
     */
    Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512,
            1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 266144, 524288, 1048576,
            2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912));

    boolean res;

    public boolean reorderedPowerOf2(int N) {
        if (set.contains(N)) {
            return true;
        }
        String s = String.valueOf(N);
        helper(s, new StringBuilder(), new boolean[s.length()], s.length());
        return res;
    }

    public void helper(String num, StringBuilder stringBuilder, boolean[] flags, int index) {
        // 找到了终止
        if (res) {
            return;
        }

        // 说有数字都排完
        if (index == 0) {
            // 判断是不是0开始的
            if (stringBuilder.charAt(0) == '0') {
                return;
            }
            // 判断是否是2的幂
            if (set.contains(Integer.valueOf(stringBuilder.toString()))) {
                res = true;
            }
            return;
        }

        // 回溯全排列
        for (int i = 0; i < num.length(); i++) {
            if (!flags[i]) {
                // 标记
                flags[i] = true;
                stringBuilder.append(num.charAt(i));

                // 递归
                helper(num, stringBuilder, flags, index - 1);

                // 回溯
                flags[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }

        }

    }
}
