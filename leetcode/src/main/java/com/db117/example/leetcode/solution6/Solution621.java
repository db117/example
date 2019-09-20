package com.db117.example.leetcode.solution6;

/**
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A','A','A','B','B','B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/19/019 14:31
 */
public class Solution621 {
    public static void main(String[] args) {
        System.out.println(new Solution621().leastInterval(new char[]{
                'A', 'A', 'A', 'B', 'B', 'B'
        }, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        // 找到最多的那个的数量
        int[] ints = new int[26];
        for (char c : tasks) {
            ints[c - 'A']++;
        }
        int max = Integer.MIN_VALUE;
        for (int i : ints) {
            max = Math.max(max, i);
        }

        // 找到最多的数量
        int count = 0;
        for (int i : ints) {
            if (i == max) {
                count++;
            }
        }
        // 最大数量-1 即是间隔为(n+1)的段数
        // count 在又多个最大数量时在间隔后面的数量
        return Math.max(tasks.length, ((max - 1) * (n + 1)) + count);
    }
}
