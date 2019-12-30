package com.db117.example.leetcode.solution11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/30/030 16:48
 */
public class Solution1122 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1122().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 8, 12, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6}
        )));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        // 记录arr2出现的次数
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i : arr2) {
            map.put(i, 0);
        }

        int ansIndex = ans.length - 1;
        for (int num : arr1) {
            Integer integer = map.get(num);
            if (integer != null) {
                map.put(num, integer + 1);
            } else {
                // 如果不在2中写入尾部
                ans[ansIndex--] = num;
            }
        }

        // 对没有出现在2中的数字进行排序
        Arrays.sort(ans, ansIndex + 1, ans.length);

        // 按照2中顺序写入
        ansIndex = 0;
        for (int num : arr2) {
            Integer size = map.get(num);
            for (int j = 0; j < size; j++) {
                ans[ansIndex++] = num;
            }
        }

        return ans;
    }
}
