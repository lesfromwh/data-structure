package com.tree;


/**
 * 二叉树的最近公共祖先
 *
 * @author liushuang 2019/5/10
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    /**
     *        3
     *      /  \
     *     5    1
     *    / \  / \
     *   6  2 0   8
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //不停的调用 入参root会改变,直到root == p || root == q就返回了.
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //1.如果左边不等于null说明 至少有一个节点在左边
        //  1.1 此时如果右边不为null,说明一个做一个右,当前入参root为最近节点
        //  1.2 此时如果右边为null,说明2个节点全在左边.开始递归.
        //2. 右边左边同理.
        return left == null ? right : right == null ? left : root;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}