package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * dfs的后序遍历 + bfs的层序遍历
 * @Datetime: 22/1/2024 下午4:02
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description">二叉树的右视图</a>
 */
public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (i == size - 1) {
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
    private List<Integer> dfsRes = new ArrayList<>();
    public List<Integer> rightSideViewDfs(TreeNode root) {
        dfs(root, 1);
        return dfsRes;
    }

    public void dfs(TreeNode res, int dep) {
        if (res == null) {
            return;
        }
        if (dep > dfsRes.size()) {
            dfsRes.add(res.val);
        }
        dfs(res.right, dep + 1);
        dfs(res.left, dep + 1);

    }
}
