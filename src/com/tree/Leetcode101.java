package com.tree;

/**
 * 对称二叉树
 * true
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * false
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * @author liushuang 2019/6/28
 */
public class Leetcode101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root21 = new TreeNode(2);
        TreeNode root22 = new TreeNode(2);
        TreeNode root31 = new TreeNode(3);
        TreeNode root32 = new TreeNode(3);
        TreeNode root41 = new TreeNode(4);
        TreeNode root42 = new TreeNode(4);
        root.left = root21;
        root.right = root22;
        root21.left = root31;
        root21.right = root41;
        root22.left = root42;
        root22.right = root32;

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        //终止条件
        if (t1 == null && t2 == null) {
            return true;
        }
        //终止条件
        if ((t1 == null || t2 == null) || t1.val != t2.val) {
            return false;
        }
        //一定是t1.val == t2.val
        boolean mirrorLeft = isMirror(t1.right, t2.left);
        boolean mirrorRight = isMirror(t1.left, t2.right);
        return mirrorLeft && mirrorRight;

        //简化写法
//        return (t1.val == t2.val)
//                && isMirror(t1.right, t2.left)
//                && isMirror(t1.left, t2.right);
    }

}
