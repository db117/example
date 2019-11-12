package com.db117.example.leetcode.solution4;

import java.util.Arrays;

/**
 * 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * <p>
 * 压缩后的长度必须始终小于或等于原数组长度。
 * <p>
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * <p>
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 *  
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * <p>
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * <p>
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 示例 2：
 * <p>
 * 输入：
 * ["a"]
 * <p>
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * <p>
 * 说明：
 * 没有任何字符串被替代。
 * 示例 3：
 * <p>
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * <p>
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 注意：
 * <p>
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/11/11/011 14:35
 */
public class Solution443 {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println(new Solution443().compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        int len = chars.length;
        if (len <= 1) {
            return len;
        }
        // 上一个字符
        char pre = chars[0];
        // 单个字符出现的次数
        int sum = 1;
        // 写入位置
        int writeIndex = 0;
        // 读取位置
        int readIndex = 1;
        while (readIndex < len) {
            if (chars[readIndex] == pre) {
                // 记录出现的次数
                sum++;
                if (readIndex == len - 1) {
                    // 最后一个字符重复
                    // 写入当前字符
                    chars[writeIndex++] = pre;
                    // 写入数字
                    char[] sumArray = String.valueOf(sum).toCharArray();
                    for (char c : sumArray) {
                        chars[writeIndex++] = c;
                    }
                }
            } else {
                // 写入当前字符
                chars[writeIndex++] = pre;
                if (sum != 1) {
                    // 写入数字
                    char[] sumArray = String.valueOf(sum).toCharArray();
                    for (char c : sumArray) {
                        chars[writeIndex++] = c;
                    }
                }

                // 最后一个字符
                if (readIndex == len - 1) {
                    chars[writeIndex++] = chars[readIndex];
                }

                // 重置数据
                pre = chars[readIndex];
                sum = 1;
            }
            readIndex++;
        }

        return writeIndex;
    }

}
