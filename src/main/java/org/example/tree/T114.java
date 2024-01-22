package org.example.tree;

/**
 * 二叉树展开为链表
 * 不考虑空间复杂度
 * 原地展开，倒着前序 ( 真聪明
 * @Datetime: 22/1/2024 下午4:20
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">二叉树展开为链表</a>
 */
public class T114 {
    private TreeNode nowEnd;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode res = new TreeNode(-111, null, null);
        nowEnd = res;
        dfs(root);
        root.left = null;
        root.right = res.right.right;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        nowEnd.right = new TreeNode(root.val, null, null);
        nowEnd = nowEnd.right;
        dfs(root.left);
        dfs(root.right);
    }

    private TreeNode nowBegin;
    public void flattenDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenDfs(root.right);
        flattenDfs(root.left);
        root.right = nowEnd;
        root.left = null;
        nowEnd = root;

    }

}