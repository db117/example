package com.db117.example.leetcode.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/11/011
 **/
public class Solution202 {
    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(4));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        do {
            temp = happyNum(temp);
            if (!set.add(temp)) {
                // 已经存在说明是死循环
                return false;
            }
        } while (temp != 1);

        // 等于1是快乐数
        return true;
    }

    public int happyNum(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10) * (num % 10);
            num = num / 10;
        }
        return res;
    }
}
