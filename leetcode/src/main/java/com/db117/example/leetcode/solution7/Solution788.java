//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？ 
//
// 
//
// 示例： 
//
// 输入: 10
//输出: 4
//解释: 
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
// 
//
// 
//
// 提示： 
//
// 
// N 的取值范围是 [1, 10000]。 
// 
// Related Topics 字符串 
// 👍 82 👎 0

package com.db117.example.leetcode.solution7;

/**
 * 788.旋转数字.rotated-digits
 *
 * @author db117
 * @date 2020-10-14 17:47:30
 **/
public class Solution788 {
    public static void main(String[] args) {
        // 7777 1661
        // 5783 1220 1318
        Solution solution = new Solution788().new Solution();
        System.out.println(solution.rotatedDigits(2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rotatedDigits(int N) {
            // 动态规划
            // 初始化前10位
            int[] temp = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
            int[] d = new int[/*小于10*/Math.max(N + 1, 10)];
            System.arraycopy(temp, 0, d, 0, 10);

            int res = 0;
            for (int i = 0; i <= N; i++) {
                int k = i / 10;
                int j = i % 10;
                if (d[k] == -1 || d[j] == -1) {
                    // 最后一位是否是 3 4 7
                    d[i] = -1;
                } else if (d[k] == 1 || d[j] == 1) {
                    // 是否含有 2 5 6 9
                    d[i] = 1;
                    res++;
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}