


//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
// Related Topics 二分查找 
// 👍 32 👎 0


package com.db117.example.leetcode.interview;

import java.util.Objects;

/**
 * 面试题 10.05.稀疏数组搜索.sparse-array-search-lcci
 *
 * @author db117
 * @since 2021-01-11 18:25:19
 **/

public class Interview_1005 {
    public static void main(String[] args) {
        Solution solution = new Interview_1005().new Solution();
        // ["DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"]
        //"mCrS"
        System.out.println(solution.findString(new String[]{
                "DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"
        }, "mCrS"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findString(String[] words, String s) {
            int left = 0, right = words.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                // 最近的非空字符串
                int near = leftNear(words, mid);
                if (near == -1 || near < left) {
                    // 左边找不到,去右边找
                    near = rightNear(words, mid);
                }
                if (near == -1 || near > right) {
                    // 在找不到就不找了
                    return -1;
                }

                int compare = words[near].compareTo(s);
                if (compare == 0) {
                    return near;
                } else if (compare < 0) {
                    left = near + 1;
                } else {
                    right = near - 1;
                }
            }
            return -1;
        }

        int leftNear(String[] words, int i) {
            // 先往左边找
            int n = i;
            while (n > 0) {
                if (!Objects.equals(words[n], "")) {
                    return n;
                }
                n--;
            }

            return -1;
        }

        int rightNear(String[] words, int i) {
            // 找不到的话就往右边找
            int n = i;
            while (n < words.length) {
                if (!Objects.equals(words[n], "")) {
                    return n;
                }
                n++;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}