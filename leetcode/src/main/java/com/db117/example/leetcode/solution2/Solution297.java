package com.db117.example.leetcode.solution2;

import com.db117.example.leetcode.util.TreeNode;
import com.db117.example.leetcode.util.TreeNodeUtil;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * ...1
 * ../ \
 * .2   3
 * ..../ \
 * ...4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/5/005 17:07
 */
public class Solution297 {
    public static void main(String[] args) {
        TreeNode treeNode = new Codec().deserialize("[1,2,3,null,null,4,5]");
        TreeNodeUtil.inorderPrint(treeNode);
        System.out.println(new Codec().serialize(treeNode));

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            String nulls = "null";
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offerFirst(root);

            List<String> res = new LinkedList<>();
            // 根节点
            res.add(String.valueOf(root.val));

            // 广度
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode last = deque.pollLast();
                    // 左节点
                    if (last.left != null) {
                        res.add(String.valueOf(last.left.val));
                        deque.offerFirst(last.left);
                    } else {
                        res.add(nulls);
                    }

                    // 右节点
                    if (last.right != null) {
                        res.add(String.valueOf(last.right.val));
                        deque.offerFirst(last.right);
                    } else {
                        res.add(nulls);
                    }
                }
            }
            // 删除多余的null
            while (true) {
                int size = res.size();
                if (nulls.equals(res.get(size - 1))) {
                    res.remove(size - 1);
                } else {
                    break;
                }
            }
            return "[" + String.join(",", res) + "]";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() < 3) {
                return null;
            }
            String[] split = data.substring(1, data.length() - 1).split(",");

            Deque<TreeNode> deque = new ArrayDeque<>(split.length >> 1);
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            deque.offerFirst(root);
            int index = 1;

            while (!deque.isEmpty()) {
                if (index > split.length - 1) {
                    break;
                }
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    // 左节点
                    if (index > split.length - 1) {
                        break;
                    }
                    TreeNode node = deque.pollLast();
                    if (!Objects.equals(split[index], "null")) {
                        node.left = new TreeNode(Integer.parseInt(split[index]));
                        // 入栈
                        deque.offerFirst(node.left);
                    }
                    index++;

                    // 右节点
                    if (index > split.length - 1) {
                        break;
                    }
                    if (!Objects.equals(split[index], "null")) {
                        node.right = new TreeNode(Integer.parseInt(split[index]));
                        // 入栈
                        deque.offerFirst(node.right);
                    }
                    index++;
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
