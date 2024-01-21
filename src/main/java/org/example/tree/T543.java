package org.example.tree;

/**
 * 二叉树的直径，凭感觉做题
 * @Datetime: 21/1/2024 下午9:35
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">二叉树直径</a>
 */
public class T543 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        getLen(root);
        return max;
    }

    public int getLen(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = getLen(root.left);
        int right = getLen(root.right);
        int temp = left + right + 2;
        if (temp > max) {
            max = temp;
        }
        return Math.max(left, right) + 1;
    }
}
