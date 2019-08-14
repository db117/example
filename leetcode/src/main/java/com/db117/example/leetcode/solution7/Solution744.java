package com.db117.example.leetcode.solution7;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * <p>
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * 注:
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/14/014
 */
public class Solution744 {
    public static void main(String[] args) {
        System.out.println(new Solution744().nextGreatestLetter(new char[]{
                'c', 'd', 'f'
        }, 'e'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        // 返回第一个的情况
        if (target < letters[0] || target >= letters[letters.length - 1]) {
            return letters[0];
        }

        int left = 0, right = letters.length - 1;
        while (left < right) {
            // 取右中位数
            int mid = (left + right + 1) >>> 1;
            // 取等于target的最右边的一个
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        // 如果找到目标,返回下一个
        // 如果没有找到目标,索引在比目标小的位置上
        return letters[left + 1];
    }
}
