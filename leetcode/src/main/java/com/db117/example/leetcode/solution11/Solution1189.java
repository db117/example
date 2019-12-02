package com.db117.example.leetcode.solution11;

/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/2/002 11:34
 */
public class Solution1189 {
    public static void main(String[] args) {
        System.out.println(new Solution1189().maxNumberOfBalloons("nlaebolko"));
    }

    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        // 统计数量
        int[] flag = new int[5];
        for (char c : chars) {
            switch (c) {
                case 'b':
                    flag[0]++;
                    break;
                case 'a':
                    flag[1]++;
                    break;
                case 'l':
                    flag[2]++;
                    break;
                case 'o':
                    flag[3]++;
                    break;
                case 'n':
                    flag[4]++;
                    break;
                default:
            }
        }

        // 两个的除以二
        flag[2] = flag[2] / 2;
        flag[3] = flag[3] / 2;

        // 统计最小的
        int min = Integer.MAX_VALUE;
        for (int value : flag) {
            min = Math.min(min, value);
        }
        return min;
    }
}
