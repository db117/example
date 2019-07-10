package com.db117.example.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/7/10
 **/
@Slf4j
public class Solution93 {

    public static void main(String[] args) {
        System.out.println(new Solution93().restoreIpAddresses("0000"));
    }


    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        backtrack(res, new char[s.length() + 3], 0, s.toCharArray(), 0, 4);

        return res;
    }

    public void backtrack(List<String> res, char[] temp, int tempIndex, char[] src, int srcIndex, int num) {
        if (tempIndex == temp.length) {
            // 全部分配好了
            if (temp[temp.length - 1] != '.') {
                // 最后一位不上 .
                res.add(new String(temp));
            }
            return;
        }

        int i = src.length - srcIndex;
        if (num == 0 || i > num * 3 || i < num) {
            // 剩余字符不够分配
            return;
        }

        // 分配
        for (int j = 1; j <= 3; j++) {
            // 长度不够直接结束
            if (srcIndex + j > src.length) {
                return;
            }
            if (j > 1) {
                // 不能是0开头
                if (src[srcIndex] == '0') {
                    return;
                }
            }
            // 是否小于等于255
            if (j == 3) {
                char c1 = src[srcIndex];
                char c2 = src[srcIndex + 1];
                char c3 = src[srcIndex + 2];
                if (c1 > '2' || (c1 == '2' && c2 > '5') || (c1 == '2' && c2 == '5' && c3 > '5')) {
                    return;
                }
            }
            // 标记赋值
            System.arraycopy(src, srcIndex, temp, tempIndex, j);
            tempIndex += j;
            srcIndex += j;
            num--;
            if (num > 0) {
                temp[tempIndex++] = '.';
            }

            // 递归调用
            backtrack(res, temp, tempIndex, src, srcIndex, num);

            // 回溯
            if (num > 0) {
                tempIndex--;
            }
            num++;
            tempIndex -= j;
            srcIndex -= j;
        }
    }
}
