package com.db117.example.leetcode.solution9;

/**
 * 944. 删列造序
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * <p>
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * <p>
 * 比如，有 A = ["abcdef", "uvwxyz"]，
 * <p>
 * <p>
 * <p>
 * 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 * <p>
 * <p>
 * <p>
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["cba", "daf", "ghi"]
 * 输出：1
 * 解释：
 * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
 * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
 * 示例 2：
 * <p>
 * 输入：["a", "b"]
 * 输出：0
 * 解释：D = {}
 * 示例 3：
 * <p>
 * 输入：["zyx", "wvu", "tsr"]
 * 输出：3
 * 解释：D = {0, 1, 2}
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/25/025 15:20
 */
public class Solution944 {
    public static void main(String[] args) {
        System.out.println(new Solution944().minDeletionSize(new String[]{
                "zyx", "wvu", "tsr"
        }));
    }

    public int minDeletionSize(String[] A) {
        String[] arr = A;
        int ans = 0;
        for (int j = 0; j < arr[0].length(); j++) {
            for (int i = 0, arrLength = arr.length; i < arrLength - 1; i++) {
                if (arr[i].charAt(j) > arr[i + 1].charAt(j)) {
                    // 找到降序的删除掉
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
