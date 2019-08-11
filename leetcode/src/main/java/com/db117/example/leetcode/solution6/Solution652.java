package com.db117.example.leetcode.solution6;

import com.db117.example.leetcode.Util.TreeNode;
import com.db117.example.leetcode.Util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * ......1
 * ...../ \
 * ....2   3
 * .../   / \
 * ..4   2   4
 * ...../
 * ....4
 * 下面是两个重复的子树：
 * <p>
 * ..2
 * ./
 * 4
 * 和
 * <p>
 * 4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/8/11/011
 **/
public class Solution652 {

    public static void main(String[] args) {
        TreeNode build = TreeNodeUtil.build(new Integer[]{
                0, 0, 0, 0, null, null, 0, null, null, null, 0
        });

        new Solution652().findDuplicateSubtrees(build).forEach(treeNode -> {
            TreeNodeUtil.preorderPrint(treeNode);
            System.out.println();
        });
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //  跟左右
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        dfs(res, map, root);

        return res;
    }

    public String dfs(List<TreeNode> res, Map<String, Integer> map, TreeNode root) {
        if (root == null) {
            return "!";
        }


        // 拼接k
        String s = root.val + dfs(res, map, root.left) + dfs(res, map, root.right);

        if (map.containsKey(s)) {
            // 是否已经存在
            if (map.get(s) == 1) {
                res.add(root);
                map.put(s, 2);
            }
        } else {
            map.put(s, 1);
        }

        // 会包含该节点的所以子节点
        return s;
    }

}
