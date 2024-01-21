package org.example.tree;

/**
 * 有序数组转为二叉树
 * 恢复二叉树家族的一员
 * @Datetime: 21/1/2024 下午10:11
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">有序数组转为二叉树</a>
 */
public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode tr = new TreeNode(nums[mid]);
        tr.left = dfs(nums, left, mid - 1);
        tr.right = dfs(nums, mid + 1, right);
        return tr;
    }
}
