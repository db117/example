package com.db117.example.leetcode.solution7;

import java.util.*;

/**
 * 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/31/031
 **/
public class Solution752 {
    public static void main(String[] args) {
        System.out.println(new Solution752().openLock(new String[]{
                        "0201", "0101", "0102", "1212", "2002"
                }
                , "0202"));
    }


    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) {
            return 0;
        }
        // 访问过的位置
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(start)) {
            return -1;
        }
        // 下一步的所有可能
        Deque<String> deque = new LinkedList<>();

        // 第一步
        deque.add(start);
        int res = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.pollFirst();
                if (cur.equals(target)) {
                    // 找到目标
                    return res;
                }
                if (!set.contains(cur)) {
                    // 加入到缓存中
                    set.add(cur);
                    // 把下一步加入到队列中
                    deque.addAll(getNext(cur));
                }
            }
            res++;
        }
        return -1;
    }

    // 下一种情况
    public List<String> getNext(String cur) {
        List<String> res = new LinkedList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = chars[i];
            // 加一
            if (c != '9') {
                chars[i] = (char) (c + 1);
            } else {
                chars[i] = '0';
            }
            res.add(new String(chars));

            // 减一
            if (c != '0') {
                chars[i] = (char) (c - 1);
            } else {
                chars[i] = '9';
            }
            res.add(new String(chars));
            chars[i] = c;
        }

        return res;
    }
}
