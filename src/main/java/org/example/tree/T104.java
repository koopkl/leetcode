package org.example.tree;

/**
 * 二叉树的最大深度
 * @Datetime: 21/1/2024 下午4:24
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">二叉树的最大深度</a>
 */
public class T104 {
    public int maxDepth(TreeNode root) {
        return reverseDepth(root, 1);
    }

    public int reverseDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        int left = reverseDepth(root.left, depth + 1);
        int right = reverseDepth(root.right, depth + 1);
        return Math.max(left, right);
    }
}
