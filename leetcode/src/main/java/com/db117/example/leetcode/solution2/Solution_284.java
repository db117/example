

//给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本
//应由 next() 方法返回的元素 peek() 出来。 
//
// 示例: 
//
// 假设迭代器被初始化为列表 [1,2,3]。
//
//调用 next() 返回 1，得到列表中的第一个元素。
//现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
//最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
// 
//
// 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？ 
// Related Topics 设计 
// 👍 70 👎 0


package com.db117.example.leetcode.solution2;

import java.util.Iterator;

/**
 * 284.顶端迭代器.peeking-iterator
 *
 * @author db117
 * @since 2021-02-09 14:38:47
 **/

public class Solution_284 {
    public static void main(String[] args) {
        PeekingIterator solution = new Solution_284()
                .new PeekingIterator(null);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        // 缓存一下
        Integer cache = null;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (cache == null) {
                cache = iterator.next();
            }
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (cache != null) {
                Integer temp = cache;
                cache = null;
                return temp;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return cache != null || iterator.hasNext();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}