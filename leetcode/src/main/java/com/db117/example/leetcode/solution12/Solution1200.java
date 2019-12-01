package com.db117.example.leetcode.solution12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/1/001 11:45
 */
public class Solution1200 {
    public static void main(String[] args) {
        System.out.println(new Solution1200().minimumAbsDifference(new int[]{
                3, 8, -10, 23, 19, -4, -14, 27
        }));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        // 最小差
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                int finalI = i;
                res.add(new ArrayList<Integer>() {{
                    add(arr[finalI]);
                    add(arr[finalI + 1]);
                }});

            }
        }

        return res;
    }
}
