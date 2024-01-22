package org.example.tree;

/**
 * 二叉搜索树的第K小的元素 二叉搜索的中序遍历结果是有序的
 * @Datetime: 22/1/2024 下午3:48
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/"></a>
 */
public class T230 {
    private int k = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        k -= 1;
        if (k == 0) {
            res = root.val;
        }
        dfs(root.right);
    }
}
