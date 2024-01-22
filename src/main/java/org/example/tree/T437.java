package org.example.tree;

/**
 * 路径总和
 * 当你使用额外的dfs写不出来的时候，考虑一下直接递归
 * @Datetime: 22/1/2024 下午7:41
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = isSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int isSum(TreeNode root, int nowSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if ((long)root.val == nowSum) {
            res++;
        }
        return res + isSum(root.left, nowSum - root.val) + isSum(root.right, nowSum - root.val);
    }

}
