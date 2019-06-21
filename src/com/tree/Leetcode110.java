package com.tree;

/**
 * 平衡二叉树
 * Balanced Binary Tree
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]

 3
 / \
 9  20
 /  \
 15   7
 * @author liushuang 2019/6/21
 */
public class Leetcode110 {


    public boolean isBalanced(TreeNode root) {
        return balance(root) != -1;
    }

    /**
     * 使用dfs 深度优先
     * 递归写法:
     * 1.终止条件
     * 2.确定返回值
     * 3.每一步递归的写法
     *
     * @param root
     * @return
     */
    public int balance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balance(root.left);
        if (left == -1) {
            return -1;
        }
        int right = balance(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(right - left) > 1) {
            return -1;
        }
        return (left > right ? left : right) + 1;
    }

}
