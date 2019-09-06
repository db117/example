package com.db117.example.leetcode.solution1;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/6/006 14:33
 */
public class Solution179 {
    public static void main(String[] args) {
        System.out.println(new Solution179().largestNumber(new int[]{
                0, 000
        }));
    }

    public String largestNumber(int[] nums) {
        String collect = Arrays.stream(nums).boxed()
                .map(Object::toString)
                .sorted((o1, o2) -> {
                    // 自然排序,字符串个数相等比较
                    String a = o1 + o2;
                    String b = o2 + o1;
                    return b.compareTo(a);
                }).collect(Collectors.joining());
        if (collect == null || collect.length() == 0) {
            return collect;
        }
        if (collect.charAt(0) == '0') {
            return "0";
        }
        return collect;
    }
}
