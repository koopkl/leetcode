package org.example.tree;

/**
 * 翻转二叉树
 * @Datetime: 21/1/2024 下午4:29
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/invert-binary-tree/">翻转二叉树</a>
 */
public class T226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
