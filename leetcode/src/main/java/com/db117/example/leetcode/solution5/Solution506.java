package com.db117.example.leetcode.solution5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/5/28/028 16:37
 */
public class Solution506 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution506().findRelativeRanks(new int[]{
                5, 4, 3, 2, 1, 9, 11, 25
        })));
    }

    public String[] findRelativeRanks(int[] nums) {
        int length = nums.length;
        String[] res = new String[length];
        int[] temp = new int[length];

        System.arraycopy(nums, 0, temp, 0, length);

        // 排序
        Arrays.sort(temp);

        // 记录每一个数字的顺序
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(temp[i], length - i);
        }

        for (int i = 0; i < length; i++) {
            // 当前位置的数字的排名
            int index = map.get(nums[i]);
            String s;
            // 转换成字符串
            switch (index) {
                case 1:
                    s = "Gold Medal";
                    break;
                case 2:
                    s = "Silver Medal";
                    break;
                case 3:
                    s = "Bronze Medal";
                    break;
                default:
                    s = String.valueOf(index);
                    break;
            }
            res[i] = s;
        }

        return res;
    }
}
