package com.tree;

import java.util.LinkedList;

/**
 * 求二叉树最大深度
 *
 * @author liushuang 2019/5/17
 */
public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = maxDepth(root);
        System.out.println(i);
    }


    /**
     * 还是广度搜索(bfs)的思路,leetcode上很慢 只超过百分之10
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int deep = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            deep++;
        }
        return deep;
    }

    /**
     * dfs深度搜索
     *     3
     *   /  \
     *  9    20
     *      /  \
     *      15  7
     * O(n)=n
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //从最左边的开始递归
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
