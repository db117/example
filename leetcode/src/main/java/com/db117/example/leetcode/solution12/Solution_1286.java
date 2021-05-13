

//请你设计一个迭代器类，包括以下内容： 
//
// 
// 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLengt
//h 。 
// 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。 
// 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。 
// 
//
// 
//
// 示例： 
//
// CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 it
//erator
//
//iterator.next(); // 返回 "ab"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "ac"
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 "bc"
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// 每组测试数据最多包含 10^4 次函数调用。 
// 题目保证每次调用函数 next 时都存在下一个字母组合。 
// 
// Related Topics 设计 回溯算法 
// 👍 42 👎 0


package com.db117.example.leetcode.solution12;

/**
 * 1286.字母组合迭代器.iterator-for-combination
 *
 * @author db117
 * @since 2021-05-13 16:25:51
 **/

public class Solution_1286 {
    public static void main(String[] args) {
        CombinationIterator solution = new Solution_1286().new CombinationIterator("abc", 2);

        //iterator.next(); // 返回 "ab"
        //iterator.hasNext(); // 返回 true
        //iterator.next(); // 返回 "ac"
        //iterator.hasNext(); // 返回 true
        //iterator.next(); // 返回 "bc"
        //iterator.hasNext(); // 返回 false
        System.out.println(solution.next());
        System.out.println(solution.hasNext());
        System.out.println(solution.next());
        System.out.println(solution.hasNext());
        System.out.println(solution.next());
        System.out.println(solution.hasNext());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator {
        private short cur;
        private StringBuilder b;
        private int combinationLength;
        private char[] chars;


        public CombinationIterator(String characters, int combinationLength) {
            chars = characters.toCharArray();
            b = new StringBuilder(combinationLength);
            this.combinationLength = combinationLength;
            // 最多15个字符,刚好使用short来标记是否使用某一个字符
            // 逆序,如果characters.length()=5 则初始为11111
            cur = (short) ((1 << characters.length()) - 1);
        }

        public String next() {
            skip();

            return genAns();
        }

        public boolean hasNext() {
            skip();

            return cur > 0;
        }

        // 跳过不符合字符数量的值
        private void skip() {
            while (cur > 0 && countOnt(cur) != combinationLength) {
                // 逆序
                cur--;
            }
        }

        // 统计1的个数
        private int countOnt(short num) {
            int ans = 0;
            while (num > 0) {
                ans++;
                num &= (num - 1);
            }
            return ans;
        }

        // 标记位置转换为字符串
        private String genAns() {
            b.setLength(0);

            // 把所有位置为1的字符挑出来
            for (int i = chars.length - 1; i >= 0; i--) {
                if (((cur >> i) & 1) == 1) {
                    b.append(chars[chars.length - 1 - i]);
                }
            }

            // 当前值已经输出
            cur--;
            return b.toString();
        }
    }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}