package com.db117.example.leetcode.solution7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 705. 设计哈希集合.
 * 不使用任何内建的哈希表库设计一个哈希集合
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/9/009
 **/
public class Solution705 {
    class MyHashSet1 {
        private List<LinkedList<Integer>> table;

        private int size = 200;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet1() {
            // 初始化
            table = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                table.add(new LinkedList<>());
            }
        }

        public void add(int key) {
            if (!contains(key)) {
                // 如果不存在添加
                table.get(key % size).addLast(key);
            }
        }

        public void remove(int key) {
            // 删除
            table.get(key % size).removeFirstOccurrence(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            // 是否存在
            return table.get(key % size).contains(key);
        }
    }

    class MyHashSet {
        boolean[] map = new boolean[1000001];

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {

        }

        public void add(int key) {
            map[key] = true;
        }

        public void remove(int key) {
            map[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return map[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
