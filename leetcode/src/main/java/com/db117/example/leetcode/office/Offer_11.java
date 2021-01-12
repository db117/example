//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 201 👎 0


package com.db117.example.leetcode.office;

/**
 * 剑指 Offer 11.旋转数组的最小数字.xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *
 * @author db117
 * @since 2021-01-12 11:07:53
 **/

public class Offer_11 {
    public static void main(String[] args) {
        Solution solution = new Offer_11().new Solution();
        System.out.println(solution.minArray(new int[]{
                3, 3, 1, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            int left = 0, right = numbers.length - 1;

            // 因为当num <= numbers[right]是不能排除当前值,所以left < right
            while (left < right) {
                int mid = left + ((right - left) >> 1);

                int num = numbers[mid];
                if (num < numbers[right]) {
                    // mid右边肯定不是最小值
                    // 当前值可能是最小值,不能排除所以 右区间为mid
                    // [left,mid]
                    right = mid;
                } else if (num > numbers[right]) {
                    // 当前值大于区间右边,则最小值在右边
                    // [mid+1,right]
                    left = mid + 1;
                } else {
                    // 可能存在  3,3,1,3,3
                    // 只能一点点减
                    right--;
                }
            }
            // 循环结束时left=right
            return numbers[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}