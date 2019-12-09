package com.db117.example.leetcode.solution9;

import java.util.*;

/**
 * 970. 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * <p>
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * <p>
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powerful-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/9/009 14:51
 */
public class Solution970 {
    public static void main(String[] args) {
        System.out.println(new Solution970().powerfulIntegers(4, 40, 100));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound < 2) {
            return new ArrayList<>();
        }
        if (x == 1 && y == 1) {
            return Collections.singletonList(2);
        }
        int[] xPow = new int[20];
        int[] yPow = new int[20];
        // 算出小于10*6的值,为-1则说明大于目标值了
        for (int i = 0; i < 20; i++) {
            int i1 = (int) Math.pow(x, i);
            xPow[i] = i1 <= bound ? i1 : -1;
            int i2 = (int) Math.pow(y, i);
            yPow[i] = i2 <= bound ? i2 : -1;
        }
        Set<Integer> set = new HashSet<>();

        // 计算出有效的值
        for (int i = 0; i < 20; i++) {
            if (xPow[i] == -1) {
                break;
            }
            for (int j = 0; j < 20; j++) {
                if (yPow[j] == -1) {
                    break;
                }
                int num = xPow[i] + yPow[j];
                if (num <= bound) {
                    set.add(num);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
