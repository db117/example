package com.db117.example.leetcode.solution3;

/**
 * 374. 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/13/013
 */
public class Solution374 {
    public static void main(String[] args) {
        System.out.println(new Solution374().guessNumber(2126753390));
    }

    private static final int NUM = 1702766719;

    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            // 左中位数
            int mid = left + ((right - left) >> 1);
            int guess = guess(mid);
            System.out.println(String.format("left->%d,right->%d,mid->%d", left, right, mid));
            if (guess == 0) {
                return mid;
            } else if (guess > 0) {
                // 舍去左边界
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num > NUM) {
            return -1;
        }
        return 1;
    }
}
