package com.tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author liushuang 2019/5/17
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int i = minDepth2(root);
        System.out.println(i);
    }

    /**
     * dfs深度搜索
     *        3
     *       /  \
     *      9    20
     *          /  \
     *          15  7
     *           \
     *            4
     */
//    错误写法
//    if(root==null) {
//        return 0;
//    }
//        return 1 + Math.min(minDepth(root.left),minDepth(root.right));

    /**
     * 1
     * / \
     * 2
     * 上面错误写法没有考虑1,2这种情况. 预期是2结果算的1.
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
     * 只有 left,right都!=null的时候才需要比较谁更小.
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //跳出递归的条件. 只要调用了深度就+1`
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    /**
     * bfs
     * 一层一层的扫描,发现的第一个也叶子节点的深度为最小深度.
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //存储每一层的节点
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int minDeep = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            //从左到右一次循环当前这一层的节点.
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                //发现的第一个也叶子节点的深度为最小深度,直接返回.
                if (poll.left == null && poll.right == null) {
                    minDeep = ++count;
                    return minDeep;
                }
            }
            count++;
        }
        return minDeep;
    }
}
