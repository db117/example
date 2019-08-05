package com.db117.example.leetcode.solution7;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/2/002
 **/
public class Solution739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(new int[]{
                89, 62, 70, 58, 47, 47, 46, 76, 100, 70
        })));
    }

    public int[] dailyTemperatures(int[] data) {
        int len = data.length;
        int[] res = new int[len];
        // 保存右边最大值
        Stack<Integer> stack = new Stack<>();
        // 最后一天
        stack.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {

            while (!stack.isEmpty() && data[stack.peek()] <= data[i]) {
                // 栈顶数字大于当前数字
                stack.pop();
            }

            // 都比当前数字小
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            // 把当前索引入队
            stack.push(i);
        }

        return res;
    }
}
