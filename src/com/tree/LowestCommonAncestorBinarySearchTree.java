package com.tree;

/**
 * 二叉搜索树 左节点比父节点小,右节点比父节点大
 *
 * @author liushuang 2019/5/12
 */
public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.如果p,q < root 说明都在左边
        //2.如果p,q > root 说明都在右边
        //3.如果p,q 一左一右 说明root就是
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
