package com.db117.example.leetcode.solution5;

import com.db117.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2020/5/22/022 16:39
 */
public class Solution501 {
    class Solution {
        public int[] findMode(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            final int[] max = {1};

            helper(root, map);
            map.forEach((k, v) -> {
                if (v < max[0]) {
                    return;
                }
                if (v > max[0]) {
                    max[0] = v;
                    res.clear();
                }
                res.add(k);
            });

            return res.stream()
                    .mapToInt(v -> v)
                    .toArray();
        }


        private void helper(TreeNode root, Map<Integer, Integer> map) {
            if (root == null) {
                return;
            }

            helper(root.left, map);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            helper(root.right, map);
        }
    }
}
