package com.db117.example.leetcode.solution7;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/9/009
 **/
public class Solution706 {
    class MyHashMap {
        int size;
        MyNode[] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            size = 100;
            table = new MyNode[size];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            MyNode myNode = new MyNode(key, value);
            MyNode head = table[hash(key)];

            if (head == null) {
                table[hash(key)] = myNode;
                return;
            }

            // 覆盖已有的值
            while (head != null) {
                if (head.k == key) {
                    head.v = value;
                    return;
                }
                head = head.next;
            }

            // 没有放入头部
            myNode.next = table[hash(key)];
            table[hash(key)] = myNode;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            MyNode head = table[hash(key)];

            while (head != null) {
                if (head.k == key) {
                    return head.v;
                }

                head = head.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {

            MyNode head = table[hash(key)];
            if (head == null) {
                return;
            }

            // 第一个就是
            if (head.k == key) {
                table[hash(key)] = head.next;
                return;
            }


            MyNode pre = null;
            do {
                if (head.k == key) {
                    pre.next = head.next;
                }
                pre = head;
                head = head.next;
            } while (head != null);
        }

        private int hash(int k) {
            return k % size;
        }

        class MyNode {
            int k;
            int v;
            MyNode next;

            public MyNode(int k, int v) {
                this.k = k;
                this.v = v;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
