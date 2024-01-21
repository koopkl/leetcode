package org.example.tree;

/**
 * 验证二叉搜索树
 * @Datetime: 21/1/2024 下午10:23
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/validate-binary-search-tree/description">验证二叉搜索树</a>
 */
public class T98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }


}
