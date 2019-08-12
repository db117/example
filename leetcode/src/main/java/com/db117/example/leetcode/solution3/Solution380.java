package com.db117.example.leetcode.solution3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 * <p>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * <p>
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * <p>
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * <p>
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * <p>
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * <p>
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * <p>
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 117
 * @date 2019/8/12/012
 */
public class Solution380 {
    public static void main(String[] args) {
        //["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        //[[],[1],[2],[2],[],[1],[2],[]]
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }

    static class RandomizedSet {
        Map<Integer, Integer> valMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int size = 0;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (valMap.containsKey(val)) {
                return false;
            }
            // 不存在添加
            valMap.put(val, size);
            indexMap.put(size, val);
            size++;
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (size <= 0 || !valMap.containsKey(val)) {
                return false;
            }
            // 如果存在则删除
            int index = valMap.remove(val);
            indexMap.remove(index);

            size--;
            if (size == 0) {
                // 已经删完了
                return true;
            }

            // 把最后一个的索引改为当前删除的
            Integer v = indexMap.get(size);
            if (v != null) {
                valMap.put(v, index);
                indexMap.put(index, v);
            }

            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            // 根据索引随机获取
            return indexMap.get(new Random().nextInt(size));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
