package org.example.tree;

import java.util.HashMap;

/**
 * 前序 + 中序 恢复二叉树(好难
 * @Datetime: 22/1/2024 下午5:13
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal"></a>
 */
public class T105 {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildNode(0, 0, inorder.length - 1);
    }

    public TreeNode buildNode(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        int i = map.get(preorder[root]);
        TreeNode temp = new TreeNode(preorder[root]);
        temp.left = buildNode(root + 1, left, i - 1);
        temp.right = buildNode(root + i - left + 1,i + 1, right);
        return temp;
    }
}
