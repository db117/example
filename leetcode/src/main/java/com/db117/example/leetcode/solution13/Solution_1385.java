//给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
//
// 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d
// 。 
//
// 
//
// 示例 1： 
//
// 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
//输出：2
//解释：
//对于 arr1[0]=4 我们有：
//|4-10|=6 > d=2 
//|4-9|=5 > d=2 
//|4-1|=3 > d=2 
//|4-8|=4 > d=2 
//所以 arr1[0]=4 符合距离要求
//
//对于 arr1[1]=5 我们有：
//|5-10|=5 > d=2 
//|5-9|=4 > d=2 
//|5-1|=4 > d=2 
//|5-8|=3 > d=2
//所以 arr1[1]=5 也符合距离要求
//
//对于 arr1[2]=8 我们有：
//|8-10|=2 <= d=2
//|8-9|=1 <= d=2
//|8-1|=7 > d=2
//|8-8|=0 <= d=2
//存在距离小于等于 2 的情况，不符合距离要求 
//
//故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2 
//
// 示例 2： 
//
// 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
//输出：2
// 
//
// 示例 3： 
//
// 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 500 
// -10^3 <= arr1[i], arr2[j] <= 10^3 
// 0 <= d <= 100 
// 
// Related Topics 数组 
// 👍 18 👎 0


package com.db117.example.leetcode.solution13;

import java.util.Arrays;

/**
 * 1385.两个数组间的距离值.find-the-distance-value-between-two-arrays
 *
 * @author db117
 * @since 2021-01-22 14:25:56
 **/

public class Solution_1385 {
    public static void main(String[] args) {
        Solution solution = new Solution_1385().new Solution();
        System.out.println(solution.findTheDistanceValue(new int[]{
                4, -3, -7, 0, -10
        }, new int[]{
                10
        }, 69));
        //[4,-3,-7,0,-10]
        //[10]
        //69
        // 0


        //[-227,537,-655,993,-526,-518,679,-420,-53,120,187,-203,-567,-75,464,-472,-324,16,215,-773,862,-563,-839,-906,-969,633,-990,756,-17,-346,820,-216,736,188,-412,881,-599,-181,-673,802,688,553,323,-689,625,871,-938,-969,-207,-703,794,361,111,-884,156,-223,-480,-734,-838,-53,335,720,-379,855,-971,-928,99,-876,75,721,-736,-913,911]
        //[-440,599,-760,-115,-814,-611,-944,23,305,-734,524,-429,406,673,731,-607,357,-84,-202,-325,292,-452,985,-468,314,301,-503,-498,-877,204,915,613,209,-642,-284,-123,239,429,147,307,69,984,-876,853,-277,120,-155,102,-592,457,802,98,-132,883,356,-857,461,-453,522,250,476,991,540,-852,-485,-637,999]
        //12
        // 36

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr2);

            int ans = 0;
            for (int i : arr1) {
                if (bs(arr2, i - d, i + d)) {
                    ans++;
                }
            }
            return ans;
        }

        // 是否有在[low,high]中
        public boolean bs(int[] arr, int low, int high) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (arr[mid] < low) {
                    left = mid + 1;
                } else if (arr[mid] > high) {
                    right = right - 1;
                } else {
                    // arr[mid]  [low,high]
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}