package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广搜来咯~~~~~~~
 * 在叶子节点的判断上，需要谨慎，否则可能多进行多两倍的时间复杂度
 * @Datetime: 21/1/2024 下午9:54
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description">层序遍历</a>
 */
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    tempRes.add(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            res.add(tempRes);
        }
        return res;
    }
}
