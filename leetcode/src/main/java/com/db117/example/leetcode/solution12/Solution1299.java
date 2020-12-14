//给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。 
//
// 完成所有替换操作后，请你返回这个数组。 
//
// 
//
// 示例： 
//
// 
//输入：arr = [17,18,5,4,6,1]
//输出：[18,6,6,6,1,-1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i] <= 10^5 
// 
// Related Topics 数组 
// 👍 53 👎 0


package com.db117.example.leetcode.solution12;

import java.util.Arrays;

/**
 * 1299.将每个元素替换为右侧最大元素.replace-elements-with-greatest-element-on-right-side
 *
 * @author db117
 * @since 2020-12-14 15:20:11
 **/

public class Solution1299 {
    public static void main(String[] args) {
        Solution solution = new Solution1299().new Solution();
        System.out.println(Arrays.toString(solution.replaceElements(new int[]{
                17, 18, 5, 4, 6, 1
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] replaceElements(int[] arr) {
            // 记录最大值
            int max = arr[arr.length - 1];
            // 先改最后面一个
            arr[arr.length - 1] = -1;

            for (int i = arr.length - 2; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = max;
                max = Math.max(max, temp);
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}