package org.example.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称二叉树
 * @Datetime: 21/1/2024 下午4:38
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/symmetric-tree/description/">对称二叉树</a>
 */
public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }

}
