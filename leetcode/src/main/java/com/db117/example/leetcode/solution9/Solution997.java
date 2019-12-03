package com.db117.example.leetcode.solution9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 997. 找到小镇的法官
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * <p>
 * 如果小镇的法官真的存在，那么：
 * <p>
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 * <p>
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] 是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/3/003 17:02
 */
public class Solution997 {
    public static void main(String[] args) {
        System.out.println(new Solution997().findJudge(2, new int[][]{
                {1, 2}
        }));
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        // 每个人被信任的人数,法官为n-1
        int[] flag = new int[n + 1];

        for (int[] ints : trust) {
            flag[ints[0]]--;
            flag[ints[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (flag[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge1(int n, int[][] trust) {
        if (n == 1) {
            return -1;
        }
        // 我信任的人
        Map<Integer, List<Integer>> map1 = new HashMap<>(n);
        // 信任我的人
        Map<Integer, List<Integer>> map2 = new HashMap<>(n);

        for (int[] ints : trust) {
            List<Integer> list1 = map1.getOrDefault(ints[0], new ArrayList<>());
            list1.add(ints[1]);
            map1.put(ints[0], list1);

            List<Integer> list2 = map2.getOrDefault(ints[1], new ArrayList<>());
            list2.add(ints[0]);
            map2.put(ints[1], list2);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> list = map2.get(i);
            // 不信任别人,但是别人都信任我
            if (map1.get(i) == null && list != null && list.size() == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
