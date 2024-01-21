package org.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归 + 栈
 * @Datetime: 21/1/2024 下午4:23
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">中序遍历</a>
 */
public class T94 {
    public List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        reverse(root);
        return res;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null ) {
            res.add(root.val);
            return;
        }
        reverse(root.left);
        res.add(root.val);
        reverse(root.right);
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root =  root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

}
