package com.db117.example.leetcode.solution2;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/15
 **/

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        // 两个目标值的异或
        int xos = 0;
        // 把所有值异或
        for (int num : nums) {
            xos ^= num;
        }

        // 不知道为什么,反正就是很牛逼,位数为1则说明两个目标值在该位不一致
        int mark = xos & (-xos);

        // 通过与这个mask进行与操作，如果为0的分为一个数组，为1的分为另一个数组。
        // 这样就把问题降低成了：“有一个数组每个数字都出现两次，有一个数字只出现了一次，求出该数字”。
        // 对这两个子问题分别进行全异或就可以得到两个解。也就是最终的数组了
        for (int num : nums) {
            if ((num & mark) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
