package org.example.tree;

/**
 * 这类题目，在递归时，需要考虑有些值是否可以被递归
 * 这里的当一个节点作为子节点，在计算他他提供给他的父节点的最大值时，只能够使用左子树与右子树的其中一个
 * 而当一个节点作为根节点，可以路径上可以包括其左节点和右节点，但是却不能够提供为上一层的节点，因为路径中不能同时包括左节点和右节点
 * @Datetime: 23/1/2024 下午4:34
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description">二叉树中的最大路径和</a>
 */
public class T124 {
    private int max = -10001;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这里 left 和 right 都需要和0比较，如果小于0，那么就不能使用，路径只会变小
        // 这是一种取巧方式，其实是在比较
        // max(root, root + left, root + right)
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // 作为根节点，这个值不能被递归，只能与max进行比较
        int res = left + right + root.val;
        if (res > max) {
            max = res;
        }
        // 作为子节点，这个值才可以被递归
        return root.val + Math.max(left, right);
    }
}
