package org.example.tree;

import org.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * @Datetime: 2024/3/6 16:39
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">二叉树的锯齿形层序遍历</a>
 */
public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            Deque<TreeNode> queueTemp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                if (pop != null) {
                    temp.add(pop.val);
                    if (flag) {
                        queueTemp.offerFirst(pop.right);
                        queueTemp.offerFirst(pop.left);
                    } else {
                        queueTemp.offerFirst(pop.left);
                        queueTemp.offerFirst(pop.right);
                    }
                }
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }
            flag = !flag;
            queue.addAll(queueTemp);
        }
        return res;
    }
}
